package ro.pub.cs.systems.eim.colocviul1_1

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

    }

    private fun addDirection(direction: String) {
        if (directions.isEmpty()) {
            directions = direction
        } else {
            directions += " | $direction"
        }
        directionsEditText.setText(directions)
    }

    override fun onResume() {
        super.onResume()
        directions = ""
        directionsEditText.setText("")
    }
}
