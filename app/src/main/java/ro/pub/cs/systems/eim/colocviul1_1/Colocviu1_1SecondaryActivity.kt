package ro.pub.cs.systems.eim.colocviul1_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Colocviu1_1SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_secondary)

        val instructionsTextView = findViewById<TextView>(R.id.instructions_text_view)
        val numberOfClicksTextView = findViewById<TextView>(R.id.number_of_clicks_text_view)
        val registerButton = findViewById<Button>(R.id.register_button)
        val cancelButton = findViewById<Button>(R.id.cancel_button)

        val directions = intent.getStringExtra("directions") ?: "No directions"
        val clicks = intent.getIntExtra("clicks", 0)

        instructionsTextView.text = "Directions: $directions"
        numberOfClicksTextView.text = "Number of clicks: $clicks"

        registerButton.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("result", "REGISTER pressed with $clicks clicks")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        cancelButton.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("result", "CANCEL pressed")
            setResult(Activity.RESULT_CANCELED, resultIntent)
            finish()
        }
    }
}
