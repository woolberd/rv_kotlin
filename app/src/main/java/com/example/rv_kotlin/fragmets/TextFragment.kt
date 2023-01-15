package com.example.rv_kotlin.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rv_kotlin.OnClick
import com.example.rv_kotlin.R
import com.example.rv_kotlin.repository.TextRepository
import com.example.rv_kotlin.adapter.TextAdapter
import com.example.rv_kotlin.data.TextModel

class TextFragment : Fragment(), OnClick{

    lateinit var rvText: RecyclerView
    private val textList = ArrayList<TextModel>()
    private val adapter = TextAdapter(textList, this)
    private val repo = TextRepository()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvText = view.findViewById(R.id.rv_names)
        val bundle = Bundle()


        initialize()
    }

    private fun initialize() {
        rvText.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repo.getListOfText())
        rvText.adapter = adapter
    }

    override fun OnClikItem(model: TextModel) {
//        val bundle = Bundle()
//        bundle.putSerializable(model.toString(), "item" )
//        val TextFragment = SecondFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, SecondFragment())
            .addToBackStack(TextFragment::class.java.name)
            .commit()

    }
}