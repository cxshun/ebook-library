<template>
    <el-form ref="form" :model="role" label-width="100px">
        <el-form-item label="名称">
            <el-input v-model="role.name"></el-input>
        </el-form-item>
        <el-form-item label="描述">
            <el-input type="textarea" v-model="role.desc"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary">保存</el-button>
            <el-button>取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script type="text/javascript">
    import Common from "../../common/common";

    export default {
        methods: {
            save() {
                this.$http.post("/roles", {
                    name: role.name,
                    desc: role.desc
                }, (response) => Common.postCallback(response));
            }
        }
    }
</script>