<template>
    <div class="post">
        <div>
            <div class="input-post">
                <input v-model="namePost" placeholder="name">
                <input v-model="description" placeholder="mota">
            </div>
            <button @click="createNewPost({ namePost, description })">ADD</button>
            <button @click="updatePost({ id, namePost, description })">UPDATE</button>
        </div>
        <div>
            <h1>Post Management</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>This_is_Name_Post</th>
                        <th>Mo_ta</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="post in postsStore.$state.listPosts" :key="post">
                        <td>{{ post.id }}</td>
                        <td>{{ post.name }}</td>
                        <td>{{ post.mota }}</td>
                        <td>
                            <button @click="deletePost(post.id)">DELETE</button>
                        </td>
                        <td>
                            <button @click="id = post.id, namePost = post.name, description = post.mota">Select</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div>
        <div>
            <input v-model="nameComment" placeholder="name">
            <select name="commentSelected" id="commentSelected" v-model="id_post">
                <option v-for="post in postsStore.$state.listPosts" :key="post" :value="post.id">{{
                        post.name
                }}</option>
            </select>
            <button @click="createNewComment({ nameComment, id_post })">ADD</button>
            <button @click="updateComment({ id_comment, nameComment, id_post })">UPDATE</button>
        </div>
        <div>
            <h1>Comments Management</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name_comment</th>
                        <th>Id_post</th>
                        <th>Name_post</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="comment in commentsStore.$state.listComments" :key="comment">
                        <td>{{ comment.id }}</td>
                        <td>{{ comment.name_comment }}</td>
                        <td>{{ comment.id_post }}</td>
                        <td>{{ comment.name_post }}</td>
                        <td>
                            <button @click="deleteComment(comment.id)">DELETE</button>
                        </td>
                        <td>
                            <button
                                @click="id_comment = comment.id, nameComment = comment.name_comment, id_post = comment.id_post">Select</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup>
import { onMounted } from '@vue/runtime-core'
import { useStore } from '../reducer/PostReducer'
import { useCommentsStore } from '../reducer/CommentsReducer'
import { getPosts, createNewPost, deletePost, updatePost } from '../saga/PostSaga'
import { getComments, createNewComment, deleteComment, updateComment } from '../saga/CommentsSaga'
import { ref } from 'vue'

const postsStore = useStore()
const commentsStore = useCommentsStore()
// console.log("LIST POSTS IN COMPONENT: ", postsStore.$state.listPosts);

const namePost = ref("")
const description = ref("")
const id = ref("")

const id_comment = ref("")
const nameComment = ref("")
const id_post = ref("")
console.log(id_post.value, "id post in component");
onMounted(() => {
    getPosts(), getComments()
})

console.log("DATA UPDATE: ", id, namePost, description);

</script>

<style>
.post {
    margin-right: 50px;
}

.input-post {
    display: flex;
    flex-direction: column;
}
</style>