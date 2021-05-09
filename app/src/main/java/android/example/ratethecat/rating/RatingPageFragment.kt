package android.example.ratethecat.rating

import android.example.ratethecat.databinding.FragmentRatingPageBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class RatingPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentRatingPageBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val catProperty = RatingPageFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = RatingPageViewModelFactory(catProperty, application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(RatingPageViewModel::class.java)


//        binding.viewModel.votingRating.observe(viewLifecycleOwner, {
//            if (binding.viewModel.votingRating.value == "1") {
//                catProperty.include_vote = "1"
//            }
//        })

        return binding.root
    }


}