<!DOCTYPE html>
<html lang="en">
#parse("content/base/back/common/head.vm")
<body style='overflow:scroll;overflow-x:hidden'>
	<div class="container bs-docs-container" style="width:100%;">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">编辑</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" id="dailogForm" action="$!{basePath}/${bussPackage}/back/${lowerName}/doEdit.do" method="POST">
						 <input type="hidden" id="btn_sub" class="btn_sub" />
						 <input type="hidden" value="$!{${lowerName}.id}" name="id" id="id" />
									<#list columnDatas as item>
									  	<#if item.domainPropertyName != 'id'>
										<#if item.columnName != 'del_stat' && item.columnName != 'creator' && item.columnName != 'editor' && item.columnName != 'create_dt' && item.columnName != 'edit_dt' && item.columnName != 'last_edit_dt' && item.columnName != 'record_version'>
											<#if item.columnType == "datetime" ||item.columnType == "date" || item.columnType == "timestamp">
												<div class="form-group mno">
												    <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">${item.columnComment}</label>
												    <div class="col-sm-8">
												      <input type="text" value="$!dateTool.format("yyyy-MM-dd",$!{${lowerName}.${item.domainPropertyName}})" name="${item.domainPropertyName}" id="${item.domainPropertyName}" class="form-control"/>
												    </div>
												</div>
											<#else>
												<div class="form-group mno">
												    <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">${item.columnComment}</label>
												    <div class="col-sm-8">
												      <input type="text" value="$!{${lowerName}.${item.domainPropertyName}}" name="${item.domainPropertyName}" id="${item.domainPropertyName}" class="form-control"/>
												    </div>
												</div>
											</#if>
										</#if>
										</#if>
									</#list> 
									<div class="form-group mno">
											<div class="col-sm-offset-1 col-sm-6">
												<button type="button" class="btn btn-default" id="formReturn" data-dismiss="modal" onclick="doUrl('$!{basePath}/${bussPackage}/back/${lowerName}/list.do')">返回</button>
	        									<button type="button" class="btn btn-primary" id="formSubmit">提交</button>
        									 </div>
        							</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript" src="$!{basePath}/plug-in/js/Validform_v5.3.2.js"></script> 
<script type="text/javascript" src="$!{basePath}/plug-in/js/forminit.p3.js"></script>  