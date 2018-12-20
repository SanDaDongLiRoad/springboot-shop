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
                                <div class="form-group">
                                    <label>编号</label>
                                    <input name="id" type="text" class="form-control" value="${(category.id)!''}" readonly/>
                                </div>
                                <div class="form-group">
                                    <label>名字</label>
                                    <input name="name" type="text" class="form-control" value="${(category.name)!''}"/>
                                </div>
                                <button type="submit" class="btn btn-default">提交</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>