<html>
    <#include "../common/header.ftl">
    <body>
    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">
        <#--主要内容content-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form role="form" method="post" action="/shop/sellerGood/save">
                            <div class="row">
                                <div class="form-group col-xs-3">
                                    <label>类目</label>
                                    <select name="categoryId" class="form-control input-sm">
                                        <#list categoryList as category>
                                            <option value="${category.id}"
                                                    <#if (good.categoryId)?? && good.categoryId == category.id>
                                                        selected
                                                    </#if>
                                            >${category.name}
                                            </option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="form-group col-xs-3">
                                    <label>名称</label>
                                    <input name="name" type="text" class="form-control input-sm" value="${(good.name)!''}"/>
                                </div>
                                <div class="form-group col-xs-3">
                                    <label>价格</label>
                                    <input name="price" type="text" class="form-control input-sm" value="${(good.price)!''}"/>
                                </div>
                                <div class="form-group col-xs-3">
                                    <label>库存</label>
                                    <input name="stock" type="number" class="form-control input-sm" value="${(good.stock)!''}"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-xs-6">
                                    <label>描述</label>
                                    <input name="description" type="text" class="form-control" value="${(good.description)!''}"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-xs-12">
                                    <label>图片</label>
                                    <input id="icon" name="icon" type="text" hidden="hidden" value="${(good.icon)!''}"/>

                                    <div class="file-loading">
                                        <input id="input-id" type="file">
                                        <p class="help-block">支持jpg、jpeg、png、gif格式，大小不超过1M</p>
                                    </div>
                                </div>
                                <input hidden type="text" name="id" value="${(good.id)!''}">
                                <button type="submit" class="btn btn-default">提交</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>
    <script>

        $(function () {
            var initialPreview = [];
            if ('${(good.icon)!""}' != '') {
                initialPreview = "<img class='kv-preview-data file-preview-image' src='${(good.icon)!""}'>"
            }

            $("#input-id").fileinput({
                uploadUrl: '/sell/image/upload',
                language: 'zh',
                browseClass: "btn btn-primary btn-block",
                showCaption: false,
                showRemove: false,
                showUpload: false,
                allowedFileExtensions: [ 'jpg', 'jpeg', 'png', 'gif' ],
                maxFileSize: 1024,
                autoReplace: true,
                overwriteInitial: true,
                maxFileCount: 1,
                initialPreview: initialPreview,
            });
        });
        //上传完成设置表单内容
        $('#input-id').on('fileuploaded', function(event, data, previewId, index) {
            if (data.response.code != 0) {
                alert(data.response.msg)
                return
            }
            $('#icon').val(data.response.data.fileName)
        });
    </script>
    </body>
</html>