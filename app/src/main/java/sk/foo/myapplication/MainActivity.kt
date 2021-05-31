package sk.foo.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(InAppReviewConfig::class.java)
        val json = adapter.toJson(InAppReviewConfig(1, 1, 1))
        Log.d("Default", "json=$json")
    }
}

@JsonClass(generateAdapter = true)
data class InAppReviewConfig(
    val timeForReviewAfterActivationMillis: Long,
    val timeForReviewAfterLoginMillis: Long,
    val inAppReviewIntervalMillis: Long
)