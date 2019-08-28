<template>
    <el-row :gutter="20">
        <el-col :span="1" :offset="19">
            <el-button type="primary" size="large" @click="dialogVisible = true">添加用户</el-button>
        </el-col>
        <el-col>
            <el-table :data="userList" stripe border style="width: 100%" empty-text="暂无数据">
                <el-table-column prop="id" label="ID" width="100"></el-table-column>
                <el-table-column prop="name" label="姓名"></el-table-column>
                <el-table-column prop="email" label="邮箱"></el-table-column>
                <el-table-column prop="isActive" label="是否有效" width="100"></el-table-column>
                <el-table-column label="操作" width="250">
                    <template slot-scope="scope">
                        <el-button @click="view(scope.row.id)" type="primary" size="small">编辑</el-button>
                        <el-button v-if="scope.row.isActive === 0" @click="activate(scope.row.id, 1)" type="primary" size="small">启用</el-button>
                        <el-button v-else-if="scope.row.isActive === 1" @click="activate(scope.row.id, 0)" type="warning" size="small">禁用</el-button>
                        <el-button @click="del(scope.row.id)" type="danger" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-col>

        <!--编辑弹窗-->
        <el-dialog title="编辑用户" :visible.sync="dialogVisible">
            <el-form ref="user" :model="user" label-width="100px">
                <el-form-item label="用户名称">
                    <el-input v-model="user.name" auto-complete="off" placeholder="请输入用户名"></el-input>
                </el-form-item>
                <el-form-item label="用户密码">
                    <el-input v-model="user.password" auto-complete="off" placeholder="请输入密码"></el-input>
                </el-form-item>
                <el-form-item label="用户邮箱">
                    <el-input v-model="user.email" auto-complete="off" placeholder="请输入邮箱"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="save()">保存</el-button>
                <el-button @click="dialogVisible = false">取消</el-button>
            </div>
        </el-dialog>
    </el-row>
</template>

<script type="text/javascript">
    import Common from '../../common/common';

    export default {
        data() {
            return {
                userList: [{}],
                user: {},
                dialogVisible: false,
                rules: {
                    name: [{required: true, message: '请输入用户名', trigger: blur}],
                    password: [{required: true, message: '请输入密码', trigger: blur}],
                    email: [{required: true, message: '请输入email', trigger: blur}]
                }
            }
        },
        mounted() {
            this.refresh();
        },
        methods: {
            activate(id, operationType) {
                this.$http.post(Common.url + "/admin/users/activate", {
                    id: id,
                    operationType: operationType
                }).then(response => Common.postCallback(response));
            },
            del(id) {
                this.$confirm("确定要删除该用户吗?", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http.delete(Common.url + "/admin/users/" + id).then((response => {
                        Common.postCallback(response);
                        this.refresh();
                    }));
                }).catch(() => {})
            },
            view() {
                this.dialogVisible = true;
            },
            save() {
                let user = this.user;
                this.$http.post(Common.url + "/admin/users", {
                    name: user.name,
                    password: user.password,
                    email: user.email
                }).then((response => {
                    Common.postCallback(response);
                    this.dialogVisible = false;
                }))
            },
            refresh() {
                this.$http.get(Common.url + '/admin/users').then((response) => {
                    this.userList = response.data.data.list;
                }).catch(response => Common.postCallback(response));
            }
        }
    }
</script>
