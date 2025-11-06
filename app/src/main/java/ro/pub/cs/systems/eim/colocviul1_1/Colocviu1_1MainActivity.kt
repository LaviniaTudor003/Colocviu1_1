package ro.pub.cs.systems.eim.colocviul1_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        if (savedInstanceState != null) {
            directions = savedInstanceState.getString("directions", "")
            numberOfClicks = savedInstanceState.getInt("numberOfClicks", 0)
            directionsEditText.setText(directions)
            Log.d("Colocviu1_1", "Restored: $directions ($numberOfClicks clicks)")
        }

        navigateButton.setOnClickListener {
            val intent = Intent(this, Colocviu1_1SecondaryActivity::class.java)
            intent.putExtra("directions", directions)
            intent.putExtra("clicks", numberOfClicks)
            startActivityForResult(intent, 100)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("directions", directions)
        outState.putInt("numberOfClicks", numberOfClicks)
        android.util.Log.d("Colocviu1_1", "onSaveInstanceState: $directions ($numberOfClicks clicks)")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        directions = savedInstanceState.getString("directions", "")
        numberOfClicks = savedInstanceState.getInt("numberOfClicks", 0)
        directionsEditText.setText(directions)

        android.util.Log.d("Colocviu1_1", "onRestoreInstanceState: $directions ($numberOfClicks clicks)")
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            val message = data?.getStringExtra("result") ?: "No result"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}