package android.example.ratethecat.list

import android.example.ratethecat.databinding.FragmentListBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


class ListFragment : Fragment() {

    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.itemGrid.adapter = ItemGridAdapter(ItemGridAdapter.OnClickListener{
            viewModel.displayPropertyRating(it)
        })

        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, {
            if (null != it) {
                this.findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToRatingPageFragment(it)
                )
                viewModel.displayPropertyRatingComplete()
            }
        })



        return binding.root
    }


}