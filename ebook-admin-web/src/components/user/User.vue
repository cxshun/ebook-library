<template>
    <el-row :gutter="20">
        <el-col :span="1" :offset="19">
            <el-button type="primary" size="large">添加用户</el-button>
        </el-col>
        <el-col>
            <el-table :data="userList" stripe style="width: 100%" empty-text="暂无数据">
                <el-table-column prop="id" label="ID" width="100"></el-table-column>
                <el-table-column prop="name" label="姓名"></el-table-column>
                <el-table-column prop="active" label="是否有效" width="100"></el-table-column>
                <el-table-column label="操作" width="200">
                    <template>
                        <el-button v-if="active === 1" @click="activate(id, 1)" type="text" size="small">启用</el-button>
                        <el-button v-else-if="active === 0" @click="activate(id, 0)" type="text" size="small">禁用</el-button>
                        <el-button @click="del(id)" type="text" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-col>
    </el-row>
</template>

<script type="text/javascript">
    import Common from '../../common/common';

    export default {
        data() {
            let userList;
            this.$http.get('/admin/users').then((response) => {
                userList = response.data;
            }).catch(response => Common.postCallback(response));
            return {
                userList: userList
            }
        },
        methods: {
            activate(id, operationType) {
                this.$http.post("/admin/users/activate", {
                    id: id,
                    operationType: operationType
                }).then(response => Common.postCallback(response));
            },
            del(id) {
                this.$http.delete("/admin/users/" + id).then((response => Common.postCallback(response)));
            }
        }
    }
</script>
