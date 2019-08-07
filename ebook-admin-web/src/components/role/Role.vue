<template>
    <el-table :data="roleList" style="width: 100%">
        <el-table-column prop="id" label="ID" width="100"></el-table-column>
        <el-table-column prop="name" label="名称" width="200"></el-table-column>
        <el-table-column prop="desc" label="描述"></el-table-column>
        <el-table-column label="操作" width="100">
            <template>
                <el-button @click="delete(id)" type="text" size="small">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script type="text/javascript">
    import Common from "../../common/common.js";

    export default {
        data() {
            this.$http.get("/admin/roles").then((response) => {
                return {
                    roleList: response.data
                }
            })
        },
        methods: {
            delete(id) {
                this.$http.delete((response) => Common.postCallback(response));
            }
        }
    }
</script>