<template>
    <el-row :gutter="20">
        <el-col :span="1" :offset="19">
            <el-button type="primary" size="large" @click="dialogVisible = true">添加权限</el-button>
        </el-col>
        <el-col>
            <el-table :data="privilegeList" stripe border style="width: 100%">
                <el-table-column prop="id" label="ID" width="100"></el-table-column>
                <el-table-column prop="name" label="名称" width="200"></el-table-column>
                <el-table-column prop="desc" label="描述"></el-table-column>
                <el-table-column prop="type" label="类型" width="100"></el-table-column>
                <el-table-column label="操作" width="250">
                    <template slot-scope="scope">
                        <el-button @click="view(scope.row.id)" type="primary" size="small">编辑</el-button>
                        <el-button @click="del(scope.row.id)" type="danger" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-col>

        <!-- 保存/修改对话框 -->
        <el-dialog title="修改权限" :visible.sync="dialogVisible" :before-close="clear">
            <el-form ref="privilege" :model="privilege" label-with="100%">
                <el-form-item label="名称">
                    <el-input v-model="privilege.name" auto-complete="off" clearable placeholder="请输入名称"></el-input>
                </el-form-item>
                <el-form-item label="描述">
                    <el-input type="textarea" v-model="privilege.desc" auto-complete="off" clearable placeholde="请输入描述"></el-input>
                </el-form-item>
                <el-form-item label="类型">
                    <el-radio-group v-model="privilege.type">
                        <el-radio :label="1">页面</el-radio>
                        <el-radio :label="2">操作点</el-radio>
                    </el-radio-group>
                </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="save()">保存</el-button>
                <el-button type="danger" @click="clear()">取消</el-button>
            </div>
        </el-dialog>
    </el-row>
</template>

<script type="text/javascript">
    import Common from "../../common/common";

    export default {
        data() {
            return {
                privilegeList: [{}],
                privilege: {},
                dialogVisible: false,
                rules: {
                    name: [{required: true, message: '请输入名称', trigger: blur}],
                    desc: [{required: true, message: '请输入描述', trigger: blur}],
                }
            }
        },
        mounted() {
            this.refresh();
        },
        methods : {
            clear() {
                this.dialogVisible = false;
                this.privilege = {}
            },
            view(id) {
                this.$http.get(Common.url + "/admin/privileges/" + id)
                    .then(response => this.privilege = response.data.data)
                    .catch((response) => Common.postCallback(response, this.$notify));
                this.dialogVisible = true;
            },
            save() {
                if (this.privilege.id !== undefined) {
                    this.update();
                } else {
                    this.$http.post(Common.url + "/admin/privileges/", this.privilege)
                        .then(response => {
                            this.dialogVisible = false;
                            this.refresh();
                        })
                }
            },
            update() {
                this.$http.put(Common.url + "/admin/privileges/", this.privilege)
                    .then(response => {
                        this.dialogVisible = false;
                        this.refresh();
                    })
            },
            del(id) {
                this.$http.delete(Common.url + "/admin/privileges/" + id)
                    .then(response => {
                        this.refresh();
                    })
            },
            refresh() {
                this.$http.get(Common.url + "/admin/privileges").then((response) => {
                    this.privilegeList = response.data.data.list;
                }).catch(response => Common.postCallback(response, this.$notify));
            }
        }
    }
</script>