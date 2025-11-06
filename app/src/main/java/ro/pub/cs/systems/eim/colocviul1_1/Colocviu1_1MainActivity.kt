package ro.pub.cs.systems.eim.colocviul1_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Colocviu1_1MainActivity : AppCompatActivity() {

    private lateinit var northButton: Button
    private lateinit var southButton: Button
    private lateinit var eastButton: Button
    private lateinit var westButton: Button
    private lateinit var navigateButton: Button
    private lateinit var directionsEditText: EditText

    private var directions = ""
    private var numberOfClicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_main)

        northButton = findViewById(R.id.north_button)
        southButton = findViewById(R.id.south_button)
        eastButton = findViewById(R.id.east_button)
        westButton = findViewById(R.id.west_button)
        navigateButton = findViewById(R.id.navigate_to_secondary_activity_button)
        directionsEditText = findViewById(R.id.directions_edit_text)

        northButton.setOnClickListener { addDirection("NORTH") }
        southButton.setOnClickListener { addDirection("SOUTH") }
        eastButton.setOnClickListener { addDirection("EAST") }
        westButton.setOnClickListener { addDirection("WEST") }

        navigateButton.setOnClickListener {
            val intent = Intent(this, Colocviu1_1SecondaryActivity::class.java)
            intent.putExtra("directions", directions)
            intent.putExtra("clicks", numberOfClicks)
            startActivity(intent)
        }

    }

    private fun addDirection(direction: String) {
        if (directions.isEmpty()) {
            directions = direction
        } else {
            directions += " | $direction"
        }
        numberOfClicks++

        android.util.Log.d("Colocviu1_1", "Număr de butoane: $numberOfClicks")

        directionsEditText.setText(directions)
    }


    override fun onResume() {
        super.onResume()
        directions = ""
        directionsEditText.setText("")
    }
}
