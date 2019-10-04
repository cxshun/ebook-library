<template>
    <el-row :gutter="22">
        <el-col :span="1" :offset="21">
            <el-button type="primary" size="large" @click="dialogVisible = true">添加角色</el-button>
        </el-col>
        <el-col>
            <el-table :data="roleList" stripe border empty-text="暂无数据" style="width: 100%">
                <el-table-column prop="id" label="ID" width="100"></el-table-column>
                <el-table-column prop="name" label="名称" width="200"></el-table-column>
                <el-table-column prop="desc" label="描述"></el-table-column>
                <el-table-column label="操作" width="150">
                    <template slot-scope="scope">
                        <el-button @click="view(scope.row.id)" type="primary" size="small">编辑</el-button>
                        <el-button @click="del(scope.row.id)" type="danger" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-col>

        <el-dialog :visible.sync="dialogVisible">
            <el-form ref="role" :model="role" label-width="100px">
                <el-form-item label="名称">
                    <el-input v-model="role.name"></el-input>
                </el-form-item>
                <el-form-item label="描述">
                    <el-input type="textarea" v-model="role.desc"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="save()">保存</el-button>
                    <el-button type="danger" @click="clear()">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-row>
</template>

<script type="text/javascript">
    import Common from "../../../common/common";

    export default {
        data() {
            return {
                dialogVisible: false,
                role: {},
                roleList: [{}]
            }
        },
        mounted() {
            this.refresh();
        },
        methods: {
            clear() {
                this.role = {};
                this.dialogVisible = false;
            },
            view(id) {
                this.$http.get(Common.url + "/admin/roles/" + id)
                    .then(response => this.role = response.data.data);
                this.dialogVisible = true;
            },
            save() {
                if (this.role.id !== undefined) {
                    this.update();
                } else {
                    this.$http.post(Common.url + "/admin/roles", this.role)
                        .then((response) => {
                            this.dialogVisible = false;
                            this.refresh();
                        })
                        .catch((response) => Common.postCallback(response, this.$notify, this.refresh));
                }
                this.clear();
            },
            update() {
                this.$http.put(Common.url + "/admin/roles", this.role)
                    .then(response => {
                        this.dialogVisible = false;
                        this.refresh();
                    })
                    .catch(response => Common.postCallback(response, this.$notify, this.refresh));
            },
            del(id) {
                this.$confirm("确定要删除该角色", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http.delete(Common.url + "/admin/roles/" + id)
                        .then(response => {
                            this.dialogVisible = false;
                            this.refresh();
                        })
                        .response(response => Common.postCallback(response, this.$notify, this.refresh));
                });
            },
            refresh() {
                this.$http.get(Common.url + "/admin/roles").then((response) => {
                    this.roleList = response.data.data.list;
                }).catch(response => Common.postCallback(response));
            }
        }
    }
</script>