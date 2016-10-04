基于SpringMVC、MySQL、Redis的网盘系统

目前已经做好的API接口：

processLogin	/u/login POST:{un:用户名 pw:密码}	{lc:登录码 lm:登录消息 tk:token令牌}	处理客户端的登录的API

processLogin	/u/welogin POST:username,password form提交	{lc:登录码 lm:登录消息 tk:token令牌}	处理web登录的API

showFileList	/sfl/{secureToken}/{path} GET:orderBy order limit	{fl:文件列表}	显示该用户path目录下的文件列表，返回JSON

showFileList	/sfl_web/{secureToken}/{path} 同上	显示该用户path目录下的文件列表视图

uploadFile	/upload/{secureToken}/{path} POST:MultipartFile file	{fid:文件的唯一标识 fn:文件名 path:文件的路径 size:文件的大小（字节） ctime:文件的创建时间 mtime:文件的最近修改时间}	上传文件到服务器并且返回该文件信息