package com.example.a4pics1word

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.example.a4pics1word.databinding.ActivityQuestionsBinding
import kotlin.random.Random

class QuestionActivity : AppCompatActivity() {
    private var currentIndex = 0
    private val answerList = mutableListOf<TextView>()
    private val optionList = mutableListOf<TextView>()
    private lateinit var binding: ActivityQuestionsBinding
    private val userAnswerList = mutableListOf<Pair<String, TextView>>()
    private var pustoy = mutableListOf<Pair<String, TextView>>()
    var level = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fillOptionAndAnswerList()


        binding.pic1.setOnClickListener {
            animationScaleUpView(1)
            animationScaleDownView(1)
        }


        binding.pic2.setOnClickListener {
            animationScaleUpView(2)
            animationScaleDownView(2)
        }

        binding.pic3.setOnClickListener {
            animationScaleUpView(3)
            animationScaleDownView(3)
        }

        binding.pic4.setOnClickListener {
            animationScaleUpView(4)
            animationScaleDownView(4)
        }


        binding.backArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        setOptionLetters()

        binding.apply {


            tvOption1.setOnClickListener { setLetters(tvOption1) }
            tvOption2.setOnClickListener { setLetters(tvOption2) }
            tvOption3.setOnClickListener { setLetters(tvOption3) }
            tvOption4.setOnClickListener { setLetters(tvOption4) }
            tvOption5.setOnClickListener { setLetters(tvOption5) }
            tvOption6.setOnClickListener { setLetters(tvOption6) }
            tvOption7.setOnClickListener { setLetters(tvOption7) }
            tvOption8.setOnClickListener { setLetters(tvOption8) }
            tvOption9.setOnClickListener { setLetters(tvOption9) }
            tvOption10.setOnClickListener { setLetters(tvOption10) }
            tvOption11.setOnClickListener { setLetters(tvOption11) }
            tvOption12.setOnClickListener { setLetters(tvOption12) }

            tvAnswer1.setOnClickListener { removeLetter(tvAnswer1) }
            tvAnswer2.setOnClickListener { removeLetter(tvAnswer2) }
            tvAnswer3.setOnClickListener { removeLetter(tvAnswer3) }
            tvAnswer4.setOnClickListener { removeLetter(tvAnswer4) }
            tvAnswer5.setOnClickListener { removeLetter(tvAnswer5) }
            tvAnswer6.setOnClickListener { removeLetter(tvAnswer6) }
            tvAnswer7.setOnClickListener { removeLetter(tvAnswer7) }
            tvAnswer8.setOnClickListener { removeLetter(tvAnswer8) }

            setQuestion()
        }


    }

    private fun animationScaleUpView(id: Int) {
        val question = Constants.getQuestions()[currentIndex]

        when (id) {
            1 -> {
                binding.bigImage.setImageResource(question.images[0])
                binding.bigImage.visibility = View.VISIBLE

                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.animation1
                    )
                )
            }

            2 -> {
                binding.bigImage.setImageResource(question.images[1])
                binding.bigImage.visibility = View.VISIBLE

                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.animation2
                    )
                )
            }

            3 -> {
                binding.bigImage.setImageResource(question.images[2])
                binding.bigImage.visibility = View.VISIBLE

                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.animation3
                    )
                )
            }

            4 -> {
                binding.bigImage.setImageResource(question.images[3])
                binding.bigImage.visibility = View.VISIBLE

                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.animation4
                    )
                )
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            binding.bigImage.visibility = View.GONE
        }, 7000)

    }


    private fun animationScaleDownView(id: Int) {
        val question = Constants.getQuestions()[currentIndex % 5]

        when (id) {
            1 -> {
                binding.bigImage.setOnClickListener {
                    binding.bigImage.startAnimation(
                        AnimationUtils.loadAnimation(
                            this, R.anim.animation_down1
                        )
                    )
                    binding.bigImage.visibility = View.GONE
                }
            }

            2 -> {
                binding.bigImage.setOnClickListener {
                    binding.bigImage.startAnimation(
                        AnimationUtils.loadAnimation(
                            this, R.anim.animation_down2
                        )
                    )
                    binding.bigImage.visibility = View.GONE
                }
            }

            3 -> {
                binding.bigImage.setOnClickListener {
                    binding.bigImage.startAnimation(
                        AnimationUtils.loadAnimation(
                            this, R.anim.animation_down3
                        )
                    )
                    binding.bigImage.visibility = View.GONE
                }
            }

            4 -> {
                binding.bigImage.setOnClickListener {
                    binding.bigImage.startAnimation(
                        AnimationUtils.loadAnimation(
                            this, R.anim.animation_down4
                        )
                    )
                    binding.bigImage.visibility = View.GONE
                }
            }
        }

    }

    fun setQuestion() {
        val que = Constants.getQuestions()[currentIndex]
        binding.apply {
            pic1.setImageResource(que.images[0])
            pic2.setImageResource(que.images[1])
            pic3.setImageResource(que.images[2])
            pic4.setImageResource(que.images[3])

        }

        answerList.forEach {
            it.text = ""
            it.visibility = View.GONE
        }

        repeat(que.answer.length) {
            answerList[it].visibility = View.VISIBLE
        }

        userAnswerList.clear()

        setOptionLetters()

    }

    private fun fillOptionAndAnswerList() {
        binding.apply {
            optionList.add(tvOption1)
            optionList.add(tvOption2)
            optionList.add(tvOption3)
            optionList.add(tvOption4)
            optionList.add(tvOption5)
            optionList.add(tvOption6)
            optionList.add(tvOption7)
            optionList.add(tvOption8)
            optionList.add(tvOption9)
            optionList.add(tvOption10)
            optionList.add(tvOption11)
            optionList.add(tvOption12)


            answerList.add(tvAnswer1)
            answerList.add(tvAnswer2)
            answerList.add(tvAnswer3)
            answerList.add(tvAnswer4)
            answerList.add(tvAnswer5)
            answerList.add(tvAnswer6)
            answerList.add(tvAnswer7)
            answerList.add(tvAnswer8)

        }
    }

    private fun setOptionLetters() {
        binding.apply {
            val optionLetters = mutableListOf<Char>()
            val thisQuestion = Constants.getQuestions()[currentIndex]
            optionLetters.addAll(thisQuestion.answer.toList())

            repeat(12 - optionLetters.size) {
                optionLetters.add(Random.nextInt(1040, 1072).toChar())
            }

            optionLetters.shuffle()

            optionList.forEachIndexed { index, textView ->
                textView.text = optionLetters[index].toString()
            }

        }
    }


    private fun setLetters(textView: TextView) {

        val letter = textView.text.toString()
        if (letter.isNotEmpty() && userAnswerList.filter { it.first != "" }.size != Constants.getQuestions()[currentIndex].answer.length) {
            val pair = Pair(letter, textView)
            val emptyIndex = userAnswerList.indexOf(Pair("", binding.tvOption1))
            if (emptyIndex == -1) {
                userAnswerList.add(pair)
            } else {
                userAnswerList[emptyIndex] = pair
            }

            textView.text = ""
            answerList[userAnswerList.indexOf(pair)].text = letter
        }

        if (userAnswerList.filter { it.first != "" }.size == Constants.getQuestions()[currentIndex].answer.length) {
            var answer = ""
            userAnswerList.forEach {
                answer += it.first
            }

            if (answer == Constants.getQuestions()[currentIndex].answer) {
                if (currentIndex >= Constants.getQuestions().lastIndex) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    level = 1
                }else{
                    currentIndex++
                    level++
                }
                binding.levelCount.text = level.toString()
                setQuestion()
            } else {
                Toast.makeText(this, "Неправильно", Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun removeLetter(textView: TextView) {
        val letter = textView.text.toString()
        if (letter.isNotEmpty()) {
            val index = answerList.indexOf(textView)
            val pair = userAnswerList[index]
            textView.text = ""
            pair.second.text = pair.first

            userAnswerList[index] = Pair("", binding.tvOption1)
        }
    }

}