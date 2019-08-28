<template>
    <el-row :gutter="20">
        <el-col :span="1" :offset="19">
            <el-button type="primary" size="large" @click="dialogVisible = true">添加用户</el-button>
        </el-col>
        <el-col>
            <el-table :data="roleList" style="width: 100%">
                <el-table-column prop="id" label="ID" width="100"></el-table-column>
                <el-table-column prop="name" label="名称" width="200"></el-table-column>
                <el-table-column prop="desc" label="描述"></el-table-column>
                <el-table-column label="操作" width="150">
                    <template slot-scope="scope">
                        <el-button @click="view" type="primary" size="small">编辑</el-button>
                        <el-button @click="del(scope.row.id)" type="danger" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-col>

        <el-dialog :visible.sync="dialogVisible">
            <el-form ref="form" :model="role" label-width="100px">
                <el-form-item label="名称">
                    <el-input v-model="role.name"></el-input>
                </el-form-item>
                <el-form-item label="描述">
                    <el-input type="textarea" v-model="role.desc"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="save">保存</el-button>
                    <el-button type="danger">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-row>
</template>

<script type="text/javascript">
    import Common from "../../common/common";

    export default {
        data() {
            return {
                dialogVisible: false,
                role: {},
                roleList: [{}]
            }
        },
        mounted() {
            this.$http.get("/admin/roles").then((response) => {
                this.roleList = response.data;
            }).catch(response => Common.postCallback(response));
        },
        methods: {
            view() {
                this.dialogVisible = true;
            },
            save() {
                this.$http.post("/roles", role).then((response) => Common.postCallback(response));
            },
            del(id) {
                this.$confirm("确定要删除该角色", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http.delete("/admin/roles/" + id).then(response => Common.postCallback(response));
                });
            }
        }
    }
</script>