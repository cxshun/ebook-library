/**
 * http请求callback处理
 * @param response  http响应体
 */
export default {
    postCallback(response, notify) {
        if (parseInt(response.data.code) !== 200) {
            notify({
                title: '提示',
                message: '操作失败，错误码为:' + response.code,
                duration: 3000
            })
        } else {
            notify({
                title: '提示',
                message: '操作成功',
                duration: 3000
            })
        }
    },
    url: "http://localhost:8080"
};
