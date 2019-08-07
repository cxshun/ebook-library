<template>
    <el-table :data="privilegeList" style="width: 100%">
        <el-table-column prop="id" label="ID" width="100"></el-table-column>
        <el-table-column prop="name" label="名称" width="200"></el-table-column>
        <el-table-column prop="desc" label="描述" width="400"></el-table-column>
        <el-table-column prop="type" label="类型" width="100"></el-table-column>
        <el-table-column label="操作" width="100">
            <template>
                <el-button @click="delete(id)" type="text" size="small">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script type="text/javascript">
    import Common from "../../common/common";

    export default {
        data() {
            this.$http.get("/admin/privileges").then((response) => {
                if (parseInt(response.code) === 200) {
                    privilegeList = response.data;
                }
            }, (response) => Common.postCallback(response));
            return {
                privilegeList: privilegeList
            }
        },
        methods : {
            delete(id) {
                this.$http.delete("/admin/privileges/" + id).then((response) => Common.postCallback(response));
            }
        }
    }
</script>