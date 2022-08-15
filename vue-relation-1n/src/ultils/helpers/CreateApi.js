import Axios from 'axios'

export default function createApi({ url, method }) {
    const request = (payload = null, paths = null, queries = null) => {
        console.log('DAY LA REQUEST: ', payload, paths, queries)
        const config = {}
        config.url = url
        config.method = method

        if (paths) {
            config.url = Object
                .keys(paths)
                .reduce((prev, curr) => prev.replace(`:${curr}`, paths[curr]), url)
        }

        if (queries) {
            config.url = Object
                .keys(queries)
                .reduce((prev, curr) => prev + `${curr}=${queries[curr]}`, `${config.url}?`)
        }

        if (payload) {
            config.data = payload
        }

        console.log('DAY LA CONFIG: ', config)

        return Axios(config)
            .then(res => res.data)
            .catch(res => res.error)
    }

    return request
}
