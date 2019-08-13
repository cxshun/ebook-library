/**
 * http请求callback处理
 * @param response  http响应体
 */
export default {
    postCallback(response) {
        if (parseInt(response.code) !== 200) {
            this.$notify({
                title: '提示',
                message: '操作失败，错误码为:' + response.code,
                duration: 3
            })
        } else {
            this.$notify({
                title: '提示',
                message: '操作成功',
                duration: 3
            })
        }
    },
    url: "http://localhost:8080"
};
