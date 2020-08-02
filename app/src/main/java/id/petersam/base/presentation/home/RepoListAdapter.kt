package id.petersam.base.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.petersam.base.databinding.ItemRepoBinding
import id.petersam.base.domain.entity.GithubRepo

class RepoListAdapter(private var repos: List<GithubRepo>) : RecyclerView.Adapter<RepoListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    class MyViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: GithubRepo) {
            binding.repo = repo
            binding.executePendingBindings()
        }
    }

    fun refreshData(repos: List<GithubRepo>) {
        this.repos = repos
        notifyDataSetChanged()
    }
}
