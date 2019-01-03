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
                            <form role="form" method="post" action="/shop/sellerCategory/saveCategory">
                                <div class = "row">
                                    <div class="form-group col-xs-3">
                                        <label>编号</label>
                                        <input name="id" type="text" class="form-control input-sm" value="${(category.id)!''}" readonly/>
                                    </div>
                                    <div class="form-group col-xs-3">
                                        <label>名字</label>
                                        <input name="name" type="text" class="form-control input-sm" value="${(category.name)!''}"/>
                                    </div>
                                    <div class="col-xs-6"></div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <button type="submit" class="btn btn-default">提交</button>
                                    </div>
                                    <div class="col-xs-3"></div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>