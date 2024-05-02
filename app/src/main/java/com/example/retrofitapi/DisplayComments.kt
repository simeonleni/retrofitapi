@file:Suppress("NAME_SHADOWING")

package com.example.retrofitapi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DisplayComments(commentsViewModel: CommentsViewModel) {
    val commentsViewModel: CommentsViewModel = viewModel()
    val commentsState by commentsViewModel.comments.observeAsState(initial = emptyList())

    CommentsList(comments = commentsState)
}
