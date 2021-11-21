package com.example.iqsikidanoliki_saregistracio

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.iqsikidanoliki_saregistracio.R

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn1: Button

    private lateinit var btn2: Button

    private lateinit var btn3: Button

    private lateinit var btn4: Button

    private lateinit var btn5: Button

    private lateinit var btn6: Button

    private lateinit var btn7: Button

    private lateinit var btn8: Button

    private lateinit var btn9: Button

    private lateinit var btnReset: Button

    private lateinit var firstPlayerScore: TextView

    private lateinit var secondPlayerScore: TextView

    private lateinit var playerOneName : TextView

    private lateinit var playerTwoName : TextView

    private lateinit var resetScore : Button

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()

    private var secondPlayer = ArrayList<Int>()

    var p1Score = 0
    var p2Score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        playerOneName = findViewById(R.id.playerOneName)
        playerTwoName = findViewById(R.id.playerTwoName)
        btnReset = findViewById(R.id.btnReset)
        firstPlayerScore = findViewById(R.id.firstPlayerScore)
        secondPlayerScore = findViewById(R.id.secondPlayerScore)
        resetScore = findViewById(R.id.resetScore)
        playerOneName.text = intent?.extras?.getString("player1","")
        playerTwoName.text = intent?.extras?.getString("player2","")
        playerOneName.text

        init()
        btnReset.setOnClickListener {

            reset()

        }

        resetScore.setOnClickListener{
            resetScore()
        }

    }

    private fun init() {

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {

        var buttonNumber = 0

        if (clickedView is Button) {

            when (clickedView.id) {

                R.id.btn1 -> buttonNumber = 1
                R.id.btn2 -> buttonNumber = 2
                R.id.btn3 -> buttonNumber = 3
                R.id.btn4 -> buttonNumber = 4
                R.id.btn5 -> buttonNumber = 5
                R.id.btn6 -> buttonNumber = 6
                R.id.btn7 -> buttonNumber = 7
                R.id.btn8 -> buttonNumber = 8
                R.id.btn9 -> buttonNumber = 9

            }

            if (buttonNumber != 0) {

                playgame(clickedView, buttonNumber)

            }

        }

    }

    private fun playgame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1) {

            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)

        }
        else {

            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.BLUE)
            activePlayer = 1
            secondPlayer.add(buttonNumber)

        }

        clickedView.isEnabled = false
        check()

    }

    private fun check() {

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {

            winnerPlayer = 1

        }

        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {

            winnerPlayer = 2

        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {

            winnerPlayer = 1

        }

        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {

            winnerPlayer = 2

        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {

            winnerPlayer = 1

        }

        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {

            winnerPlayer = 2

        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {

            winnerPlayer = 1

        }

        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {

            winnerPlayer = 2

        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {

            winnerPlayer = 1

        }

        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {

            winnerPlayer = 2

        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {

            winnerPlayer = 1

        }

        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {

            winnerPlayer = 2

        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {

            winnerPlayer = 1

        }

        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {

            winnerPlayer = 2

        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {

            winnerPlayer = 1

        }

        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {

            winnerPlayer = 2

        }

        if (firstPlayer.size + secondPlayer.size == 9) {

            winnerPlayer = 3

            if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {

                winnerPlayer = 1

                Handler().postDelayed({

                    reset()

                }, 500)

            }

            if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {

                winnerPlayer = 1

                Handler().postDelayed({

                    reset()

                }, 500)

            }

            if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {

                winnerPlayer = 1

                Handler().postDelayed({

                    reset()

                }, 500)

            }

            if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {

                winnerPlayer = 1

                Handler().postDelayed({

                    reset()

                }, 500)

            }

            if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {

                winnerPlayer = 1

                Handler().postDelayed({

                    reset()

                }, 500)

            }

            if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {

                winnerPlayer = 1

                Handler().postDelayed({

                    reset()

                }, 500)

            }

            if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {

                winnerPlayer = 1

                Handler().postDelayed({

                    reset()

                }, 500)

            }

            if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {

                winnerPlayer = 1

                Handler().postDelayed({

                    reset()

                }, 500)

            }

        }

        if (winnerPlayer == 1) {

            Toast.makeText(this, "X", Toast.LENGTH_SHORT).show()

            p1Score++
            firstPlayerScore.text = p1Score.toString()

            activePlayer = 1

            firstPlayer.clear()
            secondPlayer.clear()

            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false

            Handler().postDelayed({

                reset()

            }, 500)

            if(btn1.text == ""){

                btn1.setBackgroundColor(Color.GRAY)

            }

            if(btn2.text == ""){

                btn2.setBackgroundColor(Color.GRAY)

            }

            if(btn3.text == ""){

                btn3.setBackgroundColor(Color.GRAY)

            }

            if(btn4.text == ""){

                btn4.setBackgroundColor(Color.GRAY)

            }

            if(btn5.text == ""){

                btn5.setBackgroundColor(Color.GRAY)

            }

            if(btn6.text == ""){

                btn6.setBackgroundColor(Color.GRAY)

            }

            if(btn7.text == ""){

                btn7.setBackgroundColor(Color.GRAY)

            }

            if(btn8.text == ""){

                btn8.setBackgroundColor(Color.GRAY)

            }

            if(btn9.text == ""){

                btn9.setBackgroundColor(Color.GRAY)

            }

            if(firstPlayer.size + secondPlayer.size == 9){

            }

        }
        else if (winnerPlayer == 2) {

            Toast.makeText(this, "0", Toast.LENGTH_SHORT).show()

            p2Score++
            secondPlayerScore.text = p2Score.toString()

            activePlayer = 1

            firstPlayer.clear()
            secondPlayer.clear()

            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false

            Handler().postDelayed({

                reset()

            },500)
            if(btn1.text == ""){

                btn1.setBackgroundColor(Color.GRAY)

            }

            if(btn2.text == ""){

                btn2.setBackgroundColor(Color.GRAY)

            }

            if(btn3.text == ""){

                btn3.setBackgroundColor(Color.GRAY)

            }

            if(btn4.text == ""){

                btn4.setBackgroundColor(Color.GRAY)

            }

            if(btn5.text == ""){

                btn5.setBackgroundColor(Color.GRAY)

            }

            if(btn6.text == ""){

                btn6.setBackgroundColor(Color.GRAY)

            }

            if(btn7.text == ""){

                btn7.setBackgroundColor(Color.GRAY)

            }

            if(btn8.text == ""){

                btn8.setBackgroundColor(Color.GRAY)

            }

            if(btn9.text == ""){

                btn9.setBackgroundColor(Color.GRAY)

            }

        }

        else if (winnerPlayer == 3){

            Toast.makeText(this, "ფრე", Toast.LENGTH_SHORT).show()

            Handler().postDelayed({

                reset()

            },500)

        }

    }

    private fun reset() {

        btn1.text = ""
        btn1.setBackgroundColor(Color.rgb(128, 0, 128))
        btn1.isEnabled = true
        btn2.text = ""
        btn2.setBackgroundColor(Color.rgb(128, 0, 128))
        btn2.isEnabled = true
        btn3.text = ""
        btn3.setBackgroundColor(Color.rgb(128, 0, 128))
        btn3.isEnabled = true
        btn4.text = ""
        btn4.setBackgroundColor(Color.rgb(128, 0, 128))
        btn4.isEnabled = true
        btn5.text = ""
        btn5.setBackgroundColor(Color.rgb(128, 0, 128))
        btn5.isEnabled = true
        btn6.text = ""
        btn6.setBackgroundColor(Color.rgb(128, 0, 128))
        btn6.isEnabled = true
        btn7.text = ""
        btn7.setBackgroundColor(Color.rgb(128, 0, 128))
        btn7.isEnabled = true
        btn8.text = ""
        btn8.setBackgroundColor(Color.rgb(128, 0, 128))
        btn8.isEnabled = true
        btn9.text = ""
        btn9.setBackgroundColor(Color.rgb(128, 0, 128))
        btn9.isEnabled = true

        activePlayer = 1

        firstPlayer.clear()
        secondPlayer.clear()

    }

    private fun resetScore() {
        if (p1Score!=0){
            p1Score=0
        }
        if (p2Score!=0){
            p2Score=0
        }
        firstPlayerScore.text=p1Score.toString()
        secondPlayerScore.text=p2Score.toString()
        reset()
    }

}
