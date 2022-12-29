package com.uniq.lostmarket

import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uniq.lostmarket.api.LostarkApi
import com.uniq.lostmarket.api.enums.ServerLoadMessage
import com.uniq.lostmarket.api.models.OpenApiStatus
import com.uniq.lostmarket.databinding.ActivityLoadingBinding
import kotlinx.android.synthetic.main.activity_loading.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.KeyStore

class LoadingActivity : AppCompatActivity() {

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        GlobalScope.async {
            isServerOpen()
        }
    }

    private suspend fun isServerOpen()  {
        CoroutineScope(Dispatchers.IO).launch {
            var isResponse = false
            var isSuccess = false
            var resultMsg = ""

            launch {
                setProcMsg("서버 상태 확인중..")
                try {
                    val api = LostarkApi.create()
                    api.getServerStatus().enqueue(object: Callback<OpenApiStatus> {
                        override fun onResponse(
                            call: Call<OpenApiStatus>,
                            response: Response<OpenApiStatus>
                        ) {
                            Log.d(ContentValues.TAG, "응답 받음")
                            if (response.body()?.ResultCode == "SUCCESS") {
                                isSuccess = true
                                resultMsg = ServerLoadMessage.CONNECTION_SUCCESS.result
                            } else {
                                resultMsg = ServerLoadMessage.CONNECTION_FAIL.result
                            }
                            isResponse = true
                        }
                        override fun onFailure(call: Call<OpenApiStatus>, t: Throwable) {
                            Log.d(ContentValues.TAG, "응답 받지못함")
                            resultMsg = ServerLoadMessage.API_CONNECTION_FAIL.result
                            isResponse = true
                        }
                    })
                } catch (e: Exception) {
                    Log.e("Error", "${e.message}")
                    resultMsg = ServerLoadMessage.ERROR.result
                    isResponse = true
                }
            }

            val waitResponse: Boolean =
                withContext(Dispatchers.Default) {
                    while (isResponse.not()) {
                        delay(100)
                    }
                    setProcMsg(resultMsg)
                    delay(500)
                    isSuccess
                }

            if (waitResponse) {
                startActivity(Intent(this@LoadingActivity, MainActivity::class.java))
            } else {
                val builder = AlertDialog.Builder(this@LoadingActivity)
                builder.setTitle(resultMsg)
                    .setMessage(
                        when(resultMsg) {
                            ServerLoadMessage.CONNECTION_FAIL.result ->
                                ServerLoadMessage.CONNECTION_FAIL.message
                            ServerLoadMessage.API_CONNECTION_FAIL.result ->
                                ServerLoadMessage.API_CONNECTION_FAIL.message
                            else ->
                                ServerLoadMessage.ERROR.message
                        }
                    ).setPositiveButton("확인",
                        DialogInterface.OnClickListener { _, _ -> }
                    )
                finish()
            }
        }
    }

    private suspend fun setProcMsg(msg: String) {
        withContext(Dispatchers.Main) {
            textview_process.text = msg
        }
    }
}