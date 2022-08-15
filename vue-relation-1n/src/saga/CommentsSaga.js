import { useCommentsStore } from '../reducer/CommentsReducer'
import { commentsApi } from '../api'

async function getComments() {
    const actions = useCommentsStore()
    console.log('res saga:')
    await actions.getRequest()
    try {
        let res = await commentsApi.getComments()
        await actions.getSuccess(res.data)
    } catch (error) {
        await actions.getFailure(error)
    }
}
async function createNewComment(payload) {
    const actions = useCommentsStore()
    console.log('PAYLOAD IN SAGA: ', payload)
    await actions.addRequest()
    try {
        let res = await commentsApi.addComment({ name_comment: payload.nameComment, id_post: payload.id_post }, null, null)
        await actions.addSuccess()
        await getComments()
    } catch (error) {
        await actions.addFailure(error)
    }
}
async function deleteComment(payload) {
    const actions = useCommentsStore()
    // console.log('PAYLOAD IN SAGA: ', payload)
    await actions.deleteRequest()
    try {
        let res = await commentsApi.deleteComment(null, { id: payload }, null)
        await actions.deleteSuccess()
        await getComments()
    } catch (error) {
        await actions.deleteFailure(error)
    }
}
async function updateComment(payload) {
    const actions = useCommentsStore()
    console.log('PAYLOAD IN SAGA: ', payload)
    await actions.updateRequest()
    try {
        let res = await commentsApi.updateComment({ name_comment: payload.nameComment, id_post: payload.id_post }, { id: payload.id_comment }, null)
        await actions.updateSuccess()
        await getComments()
    } catch (error) {
        await actions.updateFailure(error)
    }
}

export {
    getComments, createNewComment, deleteComment, updateComment
}
