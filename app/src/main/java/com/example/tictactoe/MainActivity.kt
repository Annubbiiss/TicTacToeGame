package com.example.tictactoe

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var player = "player1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            buttonClicking(binding.btn1)
        }
        binding.btn2.setOnClickListener {
            buttonClicking(binding.btn2)
        }
        binding.btn3.setOnClickListener {
            buttonClicking(binding.btn3)
        }
        binding.btn3.setOnClickListener {
            buttonClicking(binding.btn3)
        }
        binding.btn4.setOnClickListener {
            buttonClicking(binding.btn4)
        }
        binding.btn5.setOnClickListener {
            buttonClicking(binding.btn5)
        }
        binding.btn6.setOnClickListener {
            buttonClicking(binding.btn6)
        }
        binding.btn7.setOnClickListener {
            buttonClicking(binding.btn7)
        }
        binding.btn8.setOnClickListener {
            buttonClicking(binding.btn8)
        }
        binding.btn9.setOnClickListener {
            buttonClicking(binding.btn9)
        }

binding.resetButton.setOnClickListener { playAgain()
}


    }



fun playAgain(){

        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
enableButtons()
    binding.result.text = ""
    binding.textView.text = "Tic Tac Toe Game"

}
    private fun buttonClicking(button: Button){

        if (button.text == "") {
            if (player == "player1") {
                player = "player2"
                button.text = "x"
            } else {
                player = "player1"
                button.text = "o"

            }
        }
gameOver()
    }

    fun gameOver(){
        if (binding.btn1.text =="x" && binding.btn2.text =="x" && binding.btn3.text =="x"
            ||binding.btn4.text =="x" && binding.btn5.text =="x" && binding.btn6.text =="x"
            ||binding.btn7.text =="x" && binding.btn8.text =="x" && binding.btn9.text =="x"
            ||binding.btn1.text =="x" && binding.btn5.text =="x" && binding.btn9.text =="x"
            ||binding.btn3.text =="x" && binding.btn5.text =="x" && binding.btn7.text =="x"
            ||binding.btn1.text =="x" && binding.btn4.text =="x" && binding.btn7.text =="x"
            ||binding.btn2.text =="x" && binding.btn5.text =="x" && binding.btn8.text =="x"
            ||binding.btn3.text =="x" && binding.btn6.text =="x" && binding.btn9.text =="x"

        ){
            binding.textView.text = ""
            binding.result.text = "X Won the Game "
            when_X_Wins(this)
            disableButtons()
        }

        else if(binding.btn1.text =="o" && binding.btn2.text =="o" && binding.btn3.text =="o"
                    ||binding.btn4.text =="o" && binding.btn5.text =="o" && binding.btn6.text =="o"
                    ||binding.btn7.text =="o" && binding.btn8.text =="o" && binding.btn9.text =="o"
                    ||binding.btn1.text =="o" && binding.btn5.text =="o" && binding.btn9.text =="o"
                    ||binding.btn3.text =="o" && binding.btn5.text =="o" && binding.btn7.text =="o"
                    ||binding.btn1.text =="o" && binding.btn4.text =="o" && binding.btn7.text =="o"
                    ||binding.btn2.text =="o" && binding.btn5.text =="o" && binding.btn8.text =="o"
                    ||binding.btn3.text =="o" && binding.btn6.text =="o" && binding.btn9.text =="o"

                    )
        {
            binding.textView.text = ""
            binding.result.text = "O Won the Game "
            when_O_Wins(this)
                disableButtons()

        }
        else{
if (binding.btn1.text!=""&&binding.btn2.text!=""&&binding.btn3.text!=""&&binding.btn4.text!=""
    &&binding.btn5.text!=""&&binding.btn6.text!=""&&binding.btn7.text!=""&&binding.btn8.text!=""&&binding.btn9.text!=""){
    binding.textView.text = ""
    binding.result.text = "Draw No one Wins "
    when_Draw(this)
    disableButtons()

}

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy","Method Called")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop","Method Called")

    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart","Method Called")

    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause","Method Called")

    }
    override fun onResume() {
        super.onResume()
        Log.e("onResume","Method Called")

    }
    private fun disableButtons() {
        binding.btn1.isEnabled = false
        binding.btn2.isEnabled = false
        binding.btn3.isEnabled = false
        binding.btn4.isEnabled = false
        binding.btn5.isEnabled = false
        binding.btn6.isEnabled = false
        binding.btn7.isEnabled = false
        binding.btn8.isEnabled = false
        binding.btn9.isEnabled = false


    }

    private fun enableButtons() {
        binding.btn1.isEnabled = true
        binding.btn2.isEnabled = true
        binding.btn3.isEnabled = true
        binding.btn4.isEnabled = true
        binding.btn5.isEnabled = true
        binding.btn6.isEnabled = true
        binding.btn7.isEnabled = true
        binding.btn8.isEnabled = true
        binding.btn9.isEnabled = true


    }

    fun when_X_Wins(context: Context) {
        val alertDialog = AlertDialog.Builder(context)

        alertDialog.apply {
            //setIcon(R.drawable.ic_hello)
            setTitle("Game Over")
            setMessage("X Win!!")
            setPositiveButton("Play again") { _: DialogInterface?, _: Int ->
                playAgain()
            }

            setNegativeButton("OK") { _, _ ->

            }

        }.create().show()
    }

    fun when_Draw(context: Context) {
        val alertDialog = AlertDialog.Builder(context)

        alertDialog.apply {
            //setIcon(R.drawable.ic_hello)
            setTitle("Game Over")
            setMessage("Draw Game !!")
            setPositiveButton("Play again") { _: DialogInterface?, _: Int ->
                playAgain()
            }

            setNegativeButton("OK") { _, _ ->

            }

        }.create().show()
    }

    fun when_O_Wins(context: Context) {
        val alertDialog = AlertDialog.Builder(context)

        alertDialog.apply {
            //setIcon(R.drawable.ic_hello)
            setTitle("Game Over")
            setMessage("O Win !!")
            setPositiveButton("Play again") { _: DialogInterface?, _: Int ->
            playAgain()
            }

            setNegativeButton("OK") { _, _ ->
            }

        }.create().show()
    }
}
