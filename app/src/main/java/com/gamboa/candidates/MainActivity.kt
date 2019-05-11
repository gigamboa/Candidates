package com.gamboa.candidates

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listIndex: Int = 0

        val koala = Candidates()
        koala.name = "Koala"
        koala.picture = R.drawable.koala

        val hog = Candidates()
        hog.name = "Hog"
        hog.picture = R.drawable.hog

        val crab = Candidates()
        crab.name = "Crab"
        crab.picture = R.drawable.crab

        val racoon = Candidates()
        racoon.name = "Racoon"
        racoon.picture = R.drawable.racoon

        val sloth = Candidates()
        sloth.name = "Sloth"
        sloth.picture = R.drawable.sloth


        var candidatesList = arrayOf(koala, hog, crab, racoon, sloth)


        //First candidate
        candidateName.text = candidatesList.get(listIndex).name
        candidateImage.setBackgroundResource(candidatesList.get(listIndex).picture)
        voteDisplay.text = candidatesList.get(listIndex).votes.toString()

        fun nextCandidates() {

            if (listIndex >=0 && listIndex < candidatesList.size - 1) {

                listIndex += 1

                var next = candidatesList.get(listIndex)

                candidateName.text = next.name
                candidateImage.setBackgroundResource(next.picture)
                voteDisplay.text = next.votes.toString()

            } else {

                listIndex = 0

                var next = candidatesList.get(listIndex)

                candidateName.text = next.name
                candidateImage.setBackgroundResource(next.picture)
                voteDisplay.text = next.votes.toString()
            }
        }

        fun previousCandidates() {

            if (listIndex > 0) {

                listIndex -= 1

                var next = candidatesList.get(listIndex)

                candidateName.text = next.name
                candidateImage.setBackgroundResource(next.picture)
                voteDisplay.text = next.votes.toString()

            } else {

                listIndex = candidatesList.size - 1

                var next = candidatesList.get(listIndex)

                candidateName.text = next.name
                candidateImage.setBackgroundResource(next.picture)
                voteDisplay.text = next.votes.toString()
            }
        }

        fun voteFor() {

            candidatesList.get(listIndex).votes += 1

            voteDisplay.text = candidatesList.get(listIndex).votes.toString()
        }

        nextCandidate.setOnClickListener {

            nextCandidates()

        }

        prevCandidate.setOnClickListener {

            previousCandidates()

        }

        voteButton.setOnClickListener {

            voteFor()

        }

    }
}
