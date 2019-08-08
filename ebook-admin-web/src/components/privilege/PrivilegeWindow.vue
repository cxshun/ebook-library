<template>
    <el-form ref="privilege" :model="privilege" label-width="100px">
        <el-form-item label="名称">
            <el-input v-mode="privilege.name"></el-input>
        </el-form-item>
        <el-form-item label="描述">
            <el-input type="textarea" v-model="privilege.desc"></el-input>
        </el-form-item>
        <el-form-item label="类型">
            <el-radio-group v-model="privilege.type">
                <el-radio label="页" value="1"></el-radio>
                <el-radio label="点" value="2"></el-radio>
            </el-radio-group>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="save">保存</el-button>
            <el-button>取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script type="text/javascript">
    import Common from '../../common/common';

    export default {
        methods : {
            save() {
            }
        }
    }
</script>