package com.example.myapplication


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(),OnClickListener {


     lateinit var button1: Button
     lateinit var button2: Button
     lateinit var button3: Button
     lateinit var button4: Button
     lateinit var button5: Button
     lateinit var button6: Button
     lateinit var button7: Button
     lateinit var button8: Button
     lateinit var button9: Button
     lateinit var reset:Button
      private var activeplayer=1
      private var player1check=ArrayList<Int>()
      private var player2check=ArrayList<Int>()
      private var winner=0
      private lateinit var pl1intstr:String
      private lateinit var pl2intstr:String
      private lateinit var num1:TextView
      private lateinit var num2:TextView
      private  var count1=0
      private  var count2=0







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        var pl1 = findViewById<TextView>(R.id.pl1)
        var pl2 = findViewById<TextView>(R.id.pl2)
        var pl1int = intent.getStringExtra("player1")
        var pl2int = intent.getStringExtra("player2")
        pl1intstr= pl1int.toString()
        pl2intstr= pl2int.toString()

        pl1.text = pl1int
        pl2.text = pl2int

        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        num1=findViewById(R.id.num1)
        num2=findViewById(R.id.num2)






        reset=findViewById(R.id.Reset)
        reset.setOnClickListener{
            winner=0
            player1check.clear()
            player2check.clear()
            button1.text=""
            button2.text=""
            button3.text=""
            button4.text=""
            button5.text=""
            button6.text=""
            button7.text=""
            button8.text=""
            button9.text=""
            button1.setBackgroundColor(Color.BLACK)
            button2.setBackgroundColor(Color.BLACK)
            button3.setBackgroundColor(Color.BLACK)
            button4.setBackgroundColor(Color.BLACK)
            button5.setBackgroundColor(Color.BLACK)
            button6.setBackgroundColor(Color.BLACK)
            button7.setBackgroundColor(Color.BLACK)
            button8.setBackgroundColor(Color.BLACK)
            button9.setBackgroundColor(Color.BLACK)
            button1.isEnabled=true
            button2.isEnabled=true
            button3.isEnabled=true
            button4.isEnabled=true
            button5.isEnabled=true
            button6.isEnabled=true
            button7.isEnabled=true
            button8.isEnabled=true
            button9.isEnabled=true


        }





    }




    override fun onClick(Clickedview: View?) {

        if (Clickedview is Button){
            var buttonnum=0
            when (Clickedview.id){
                R.id.button1 ->buttonnum=1
                R.id.button2 ->buttonnum=2
                R.id.button3 ->buttonnum=3
                R.id.button4 ->buttonnum=4
                R.id.button5 ->buttonnum=5
                R.id.button6 ->buttonnum=6
                R.id.button7 ->buttonnum=7
                R.id.button8 ->buttonnum=8
                R.id.button9 ->buttonnum=9



            }

            play(buttonnum,Clickedview )

        }

    }

    private fun play(buttonnum: Int, clickedview: Button) {
        if (activeplayer==1){
            clickedview.text="X"
            activeplayer=2
            clickedview.setBackgroundColor(Color.CYAN)
            player1check.add(buttonnum)
            clickedview.isEnabled=false
        }else if(activeplayer==2){
            clickedview.text="0"
            clickedview.setBackgroundColor(Color.LTGRAY)
            activeplayer=1
            player2check.add(buttonnum)
            clickedview.isEnabled=false

        }
        check()

    }

    private fun check() {


        if(player1check.contains(1)&&player1check.contains(2)&&player1check.contains(3)){
            winner=1
        }else if(player1check.contains(4)&&player1check.contains(5)&&player1check.contains(6)){
            winner=1
        }else if(player1check.contains(7)&&player1check.contains(8)&&player1check.contains(9)){
            winner=1
        }else if(player1check.contains(1)&&player1check.contains(4)&&player1check.contains(7)){
            winner=1
        }else if(player1check.contains(2)&&player1check.contains(5)&&player1check.contains(8)){
            winner=1
        }else if(player1check.contains(3)&&player1check.contains(6)&&player1check.contains(9)){
            winner=1
        }else if(player1check.contains(1)&&player1check.contains(5)&&player1check.contains(9)){
            winner=1
        }else if(player1check.contains(3)&&player1check.contains(5)&&player1check.contains(7)){
            winner=1
        }

        if(player2check.contains(1)&&player2check.contains(2)&&player2check.contains(3)){
            winner=2
        }else if(player2check.contains(4)&&player2check.contains(5)&&player2check.contains(6)){
            winner=2
        }else if(player2check.contains(7)&&player2check.contains(8)&&player2check.contains(9)){
            winner=2
        }else if(player2check.contains(1)&&player2check.contains(4)&&player2check.contains(7)){
            winner=2
        }else if(player2check.contains(2)&&player2check.contains(5)&&player2check.contains(8)){
            winner=2
        }else if(player2check.contains(3)&&player2check.contains(6)&&player2check.contains(9)){
            winner=2
        }else if(player2check.contains(1)&&player2check.contains(5)&&player2check.contains(9)){
            winner=2
        }else if(player2check.contains(3)&&player2check.contains(5)&&player2check.contains(7)){
            winner=2
        }

        if (winner==1){
            Toast.makeText(this, "goodjob ${pl1intstr}", Toast.LENGTH_LONG).show()
            count1=count1+1
            num1.text=count1.toString()
            button1.isEnabled=false
            button2.isEnabled=false
            button3.isEnabled=false
            button4.isEnabled=false
            button5.isEnabled=false
            button6.isEnabled=false
            button7.isEnabled=false
            button8.isEnabled=false
            button9.isEnabled=false

        }else if(winner==2){
            Toast.makeText(this, "goodjob ${pl2intstr}", Toast.LENGTH_LONG).show()
            count2=count2+1
            num2.text=count2.toString()
            button1.isEnabled=false
            button2.isEnabled=false
            button3.isEnabled=false
            button4.isEnabled=false
            button5.isEnabled=false
            button6.isEnabled=false
            button7.isEnabled=false
            button8.isEnabled=false
            button9.isEnabled=false

        }else if(player1check.size+player2check.size==9){
            Toast.makeText(this, "neither won", Toast.LENGTH_LONG).show()
        }

        }




    }






