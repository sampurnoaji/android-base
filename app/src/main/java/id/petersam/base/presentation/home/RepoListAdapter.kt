package id.petersam.base.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.petersam.base.databinding.ItemRepoBinding
import id.petersam.base.databinding.LayoutFooterListBinding
import id.petersam.base.domain.entity.GithubRepo
import id.petersam.base.external.NetworkState

class RepoListAdapter : PagedListAdapter<GithubRepo, RecyclerView.ViewHolder>(diffCallback) {

    private val FOOTER_TYPE = 1
    private val CONTENT_TYPE = 2
    private var state : NetworkState = NetworkState.LOADING

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == CONTENT_TYPE) ContentViewHolder.create(parent)
        else FooterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        if (viewType == CONTENT_TYPE) (holder as ContentViewHolder).bind(getItem(position) ?: return)
        else (holder as FooterViewHolder).bind()
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1
        else 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) CONTENT_TYPE
        else FOOTER_TYPE
    }

    private fun hasFooter() : Boolean {
        return super.getItemCount() != 0 && state == NetworkState.LOADING
    }

    fun setState(state: NetworkState) {
        this.state = state
        notifyItemChanged(super.getItemCount())
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<GithubRepo>() {
            override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ContentViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: GithubRepo) {
            binding.repo = repo
            binding.executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup): ContentViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRepoBinding.inflate(layoutInflater, parent, false)
                return ContentViewHolder(binding)
            }
        }
    }

    class FooterViewHolder(private val binding: LayoutFooterListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() = binding.executePendingBindings()

        companion object {
            fun create(parent: ViewGroup): FooterViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutFooterListBinding.inflate(layoutInflater, parent, false)
                return FooterViewHolder(binding)
            }
        }
    }
}
