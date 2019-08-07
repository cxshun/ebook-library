<template>
    <el-table :data="userList" style="width: 100%" stripe>
        <el-table-column prop="id" label="ID" width="200"></el-table-column>
        <el-table-column prop="name" label="姓名"></el-table-column>
        <el-table-column prop="active" label="是否有效" width="100"></el-table-column>
        <el-table-column label="操作" width="300">
            <template>
                <el-button v-if="active === 1" @click="activate(id, 1)" type="text" size="small">启用</el-button>
                <el-button v-if="active === 0" @click="activate(id, 0)" type="text" size="small">禁用</el-button>
                <el-button @click="delete(id)" type="text" size="small">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script>
    import Common from '../../common/common.js';

    export default {
        data() {
            this.$http.get('/admin/users').then((response) => {
                userList = response.data;
            }, (response) => {
                this.$notify({
                    title: '提示',
                    message: '加载失败, 错误信息为:' + response.code,
                    duration: 3
                })
            });
            return {
                userList: userList;
            }
        },
        methods: {
            activate(id, operationType) {
                this.$http.post("/admin/users/active", {
                    id: id,
                    operationType: operationType
                }).then(response => Common.postCallback(response));
            },
            delete(id) {
                this.$http.delete("/admin/users/" + id).then((response => Common.postCallback(response)));
            }
        }
    }
</script>
