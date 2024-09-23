package com.task.futbolapp.ui.screens.competitions

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.futbolapp.R
import com.task.futbolapp.data.viewmodel.CompetitionsViewModel
import com.task.futbolapp.databinding.ActivityMainBinding
import com.task.futbolapp.ui.screens.competitions.rv.RvCompetitionsAdapter
import com.task.futbolapp.ui.screens.tems.ActivityViewTeams
import com.task.futbolapp.ui.screens.tems.ActivityViewTeams.Companion.TEAM_ID
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val competitionsViewModel: CompetitionsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCompetitionsAdapter: RvCompetitionsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        initUiStateLifecycle()
    }
    private fun initRV() {
        rvCompetitionsAdapter = RvCompetitionsAdapter(
            onViewInfoClickListener = { id ->
                launchTeamsActivity(id)
            }
        )
        binding.rvCompetitions.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvCompetitionsAdapter
        }
    }
    private fun launchTeamsActivity(id: Int) {
        val intent = Intent(this, ActivityViewTeams::class.java).apply {
            putExtras(
                bundleOf(
                    TEAM_ID to id
                ) )}
        startActivity(intent)

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUiStateLifecycle() {
        lifecycleScope.launch {
            competitionsViewModel.competitions.collect { competitions ->
                competitions.competitions?.let { competitionsList ->
                    rvCompetitionsAdapter.competitions = competitionsList
                    rvCompetitionsAdapter.notifyDataSetChanged()
                }
                binding.rvCompetitions.visibility =
                    if (competitions.isLoading) View.INVISIBLE else View.VISIBLE
                binding.pbCompetitions.visibility =
                    if (competitions.isLoading.not()) View.INVISIBLE else View.VISIBLE
            }
        }
    }
}