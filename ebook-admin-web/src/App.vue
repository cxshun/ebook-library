<template>
  <div id="app">
    <el-container style="height: 500px; border: 1px solid #eee">
      <el-header>
        <el-menu :default-active="'1'" mode="horizontal">
          <el-menu-item index="1">图书管理</el-menu-item>
          <el-menu-item index="2">系统管理</el-menu-item>
        </el-menu>
      </el-header>
      <el-container>
        <el-aside width="150px" style="background-color: rgb(238, 241, 246)">
          <el-menu :default-openeds="['1']">
            <el-submenu index="1">
              <template slot="title"><i class="el-icon-user"></i>用户管理</template>
              <el-menu-item-group>
                <router-link to="/users"><el-menu-item index="1-1">用户列表</el-menu-item></router-link>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title"><i class="el-icon-bangzhu">角色管理</i></template>
              <el-menu-item-group>
                <router-link to="/roles"><el-menu-item index="2-1">角色列表</el-menu-item></router-link>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title"><i class="el-icon-info">权限管理</i></template>
              <el-menu-item-group>
                <router-link to="/privileges"><el-menu-item index="3-1">权限列表</el-menu-item></router-link>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-container>
          <el-main>
            <router-view></router-view>
          </el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<style type="text/css">
  a {
    text-decoration: none;
  }
</style>
