<template>
    <el-row :gutter="20">
        <el-col :span="1" :offset="19">
            <el-button type="primary" size="large" @click="dialogVisible = true">添加用户</el-button>
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
                        <el-button @click="del(id)" type="danger" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-col>

        <el-dialog title="新增用户" :visible.sync="dialogVisible">
            <el-form :form="form" label-width="100px">
                <el-form-item label="用户名称">
                    <el-input v-model="form.name" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="用户邮箱">
                    <el-input v-model="form.email" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="save(form)">保存</el-button>
                <el-button @click="dialogVisible = false">取消</el-button>
            </div>
        </el-dialog>
    </el-row>
</template>

<script type="text/javascript">
    import Common from '../../common/common';

    export default {
        data() {
            let userList = [];
            this.$http.get(Common.url + '/admin/users').then((response) => {
                userList = response.data.data;
            }).catch(response => Common.postCallback(response));
            return {
                userList: userList,
                form: {},
                dialogVisible: false
            }
        },
        methods: {
            activate(id, operationType) {
                this.$http.post(Common.url + "/admin/users/activate", {
                    id: id,
                    operationType: operationType
                }).then(response => Common.postCallback(response));
            },
            del(id) {
                this.$http.delete(Common.url + "/admin/users/" + id).then((response => Common.postCallback(response)));
            },
            save(form) {
                this.$http.post(Common.url + "/admin/users", {
                    form
                }).then((response => Common.postCallback(response)))
            }
        }
    }
</script>
