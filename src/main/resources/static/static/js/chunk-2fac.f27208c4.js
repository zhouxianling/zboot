(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2fac"],{AsHO:function(e,t,a){"use strict";var i=a("pPND");a.n(i).a},"RX4/":function(e,t,a){"use strict";a.r(t);var i=a("gDS+"),n=a.n(i),l=a("ef2z"),s=a("qsBl"),r={data:function(){return{treeData:[],currentPage:0,dialogTitle:"新增",isVisible:!1,isMenuVisible:!1,isDisabled:!1,isShowCheckbox:!1,defaultCheckedKeys:[],page:1,size:16,total:0,tableData:[],formData:{roleName:"",roleCode:"",roleDesc:"",menuIds:""},rules:{roleName:[{required:!0,message:"请输入角色名称",trigger:"blur"}],roleCode:[{required:!0,message:"请输入角色编码",trigger:"blur"}]}}},created:function(){var e=this;this.requestData(),Object(s.c)().then(function(t){e.treeData=t})},methods:{requestData:function(){var e=this,t={page:this.page,size:this.size};Object(l.b)(t).then(function(t){e.tableData=t.records,e.total=t.total,e.currentPage=t.current})},deleteById:function(e){var t=this;this.$Modal.confirm({title:"提示",content:"确定删除吗？",onOk:function(){Object(l.a)(e).then(function(e){t.requestData(),t.$message.success(e.msg)})}})},detail:function(e){this.handleMenuIds(e.id),this.formData=e,this.isVisible=!0,this.isDisabled=!0,this.dialogTitle="角色详情"},addClick:function(){this.isVisible=!0,this.formData={},this.isDisabled=!1,this.defaultCheckedKeys=[]},submitForm:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return!1;Object(l.c)(n()(t.formData)).then(function(e){t.requestData(),t.isVisible=!1,t.$message.success("保存成功")})})},handleSizeChange:function(){},updateById:function(e){this.isVisible=!0,this.formData=e,this.isDisabled=!1,this.handleMenuIds(e.id),this.dialogTitle="角色编辑"},handleCurrentChange:function(e){this.page=e,this.requestData()},submitMenu:function(){var e=this.$refs.treeBox.getCheckedKeys();console.log(e),e&&(this.formData.menuIds=e.join(",")),this.isMenuVisible=!1},addMenu:function(e){this.isMenuVisible=!0,this.handleMenuIds(e.id)},handleMenuIds:function(e){var t=this;Object(s.b)(e).then(function(e){t.defaultCheckedKeys=e})}}},o=(a("AsHO"),a("KHd+")),c=Object(o.a)(r,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"m-el-container"},[a("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:e.addClick}},[e._v("\n      添加\n    ")]),e._v(" "),a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.tableData,border:""}},[a("el-table-column",{attrs:{prop:"id",align:"center",label:"序号"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",prop:"roleName",label:"角色名称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"roleCode",align:"center",label:"角色编码"}}),e._v(" "),a("el-table-column",{attrs:{prop:"roleDesc",align:"center",label:"角色描述"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",align:"center",label:"时间"}}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",align:"center",width:"260",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small",icon:"el-icon-view"},on:{click:function(a){e.detail(t.row)}}},[e._v("查看")]),e._v(" "),a("el-button",{attrs:{type:"text",size:"small",icon:"el-icon-edit"},on:{click:function(a){e.updateById(t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{type:"text",size:"small",icon:"el-icon-delete"},on:{click:function(a){e.deleteById(t.row.id)}}},[e._v("删除")]),e._v(" "),a("el-button",{attrs:{type:"text",size:"small",icon:"el-icon-plus"},on:{click:function(a){e.addMenu(t.row)}}},[e._v("权限")])]}}])})],1),e._v(" "),a("el-pagination",{staticClass:"pagination-container",attrs:{"current-page":e.currentPage,"page-size":e.size,layout:"total,prev, pager, next, jumper",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.currentPage=t}}}),e._v(" "),a("el-dialog",{attrs:{title:e.dialogTitle,visible:e.isVisible},on:{"update:visible":function(t){e.isVisible=t}}},[a("el-form",{ref:"form",attrs:{model:e.formData,rules:e.rules,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"角色名称",prop:"roleName"}},[a("el-input",{attrs:{disabled:e.isDisabled},model:{value:e.formData.roleName,callback:function(t){e.$set(e.formData,"roleName",t)},expression:"formData.roleName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"角色编码",prop:"roleCode"}},[a("el-input",{attrs:{disabled:e.isDisabled},model:{value:e.formData.roleCode,callback:function(t){e.$set(e.formData,"roleCode",t)},expression:"formData.roleCode"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"角色描述"}},[a("el-input",{attrs:{disabled:e.isDisabled},model:{value:e.formData.roleDesc,callback:function(t){e.$set(e.formData,"roleDesc",t)},expression:"formData.roleDesc"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"角色权限"}},[a("el-tree",{ref:"treeBox",attrs:{data:e.treeData,"show-checkbox":"","default-expand-all":"","node-key":"id","highlight-current":"",disabled:e.isDisabled,"default-checked-keys":e.defaultCheckedKeys}})],1)],1),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{size:"small"},on:{click:function(t){e.isVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary",size:"small",disabled:e.isDisabled},on:{click:function(t){e.submitForm("form")}}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"分配权限",visible:e.isMenuVisible},on:{"update:visible":function(t){e.isMenuVisible=t}}},[a("el-tree",{ref:"treeBox",attrs:{data:e.treeData,"show-checkbox":"","default-expand-all":"","node-key":"id","highlight-current":"","default-checked-keys":e.defaultCheckedKeys}}),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.submitMenu}},[e._v("更 新")])],1)],1)],1)])},[],!1,null,null,null);c.options.__file="index.vue";t.default=c.exports},ef2z:function(e,t,a){"use strict";a.d(t,"c",function(){return l}),a.d(t,"b",function(){return s}),a.d(t,"a",function(){return r});var i=a("t3Un"),n=a("S5C5").a+"/role";function l(e){return Object(i.a)({url:n,method:"post",data:e,headers:{"Content-Type":"application/json"}})}function s(e){return Object(i.a)({url:n+"/page",method:"get",params:e})}function r(e){return Object(i.a)({url:n+"/"+e,method:"delete"})}},pPND:function(e,t,a){},qsBl:function(e,t,a){"use strict";a.d(t,"d",function(){return l}),a.d(t,"c",function(){return s}),a.d(t,"a",function(){return r}),a.d(t,"b",function(){return o});var i=a("t3Un"),n=a("S5C5").a+"/menu";function l(e){return Object(i.a)({url:n,method:"post",data:e,headers:{"Content-Type":"application/json"}})}function s(){return Object(i.a)({url:n+"/tree",method:"get"})}function r(e){return Object(i.a)({url:n+"/"+e,method:"delete"})}function o(e){return Object(i.a)({url:n+"/menuIds/"+e,method:"get"})}}}]);