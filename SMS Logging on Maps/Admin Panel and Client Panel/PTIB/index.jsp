<html>
    <head>
        <link rel="stylesheet" href="dijit/themes/claro/claro.css">
        <link rel="StyleSheet" type="text/css" href="dijit/themes/tundra/tundra.css">

        <script type="text/javascript">
            var djConfig = {
                baseScriptUri : "js/dojo/",
                parseOnLoad : true
            };
        </script>
        <script type="text/javascript" src="dojo/dojo.js"></script>
        <script>
            //=====================
            dojo.require("dojo.parser");
            dojo.require("dijit.form.Button");
            dojo.require("dijit.Dialog");
            dojo.require("dijit.form.TextBox");
            dojo.addOnLoad(showLoginDialog);
       
            function showLoginDialog() {
                //               alert(document.loginForm.login.value);
               
                var browser=navigator.appName
                var b_version=navigator.appVersion
                var version=parseFloat(b_version)
             
                if (!(browser=="Microsoft Internet Explorer") && (version>=4))
                {alert("Please use Internet Exploere 7 or higher to use this website")}
                               
               
                dijit.byId('Login').show();
                document.getElementById("username").focus();
            }
            function showForgotPasswordDialog() {
                dijit.byId('ForgotPassword').show();
            }
            function showSignUpDialogue(){
                dijit.byId('SignUp').show();
            }
            function verify()
            {
                dijit.byId('SignUp').hide();
                dijit.byId('VerificationForm').show();
            }
            function checkUser() {
                // alert("hekke");
                dojo.xhrGet({
                    url: "",
                    // url: "SessionManager",
                    load: Navigate
                   
                });
            }
            function Navigate(text) {
               
                    window.navigate("adminPanel.html");
                
            }
           
        </script>


    </head>
    <body class="tundra">
        <div dojoType="dijit.Dialog" id="ForgotPassword" title="ForgotPassword" data-dojo-props='closable:false'>

        </div>
        
        <div dojoType="dijit.Dialog" id="VerificationForm" title="Verification" data-dojo-props='closable:false'>
            <form >
                <table >

                    <tr>
                        <td><label>Enter Verification code</label></td>
                    </tr>
                    <tr>
                        <td><input type="text" trim="true" dojoType="dijit.form.TextBox" id="Name" name="Name" required="true" focus="true"/></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td colspan="2" align="right">
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td></td>
                                    <td align="right" valign="top"><button dojoType="dijit.form.Button" type="button" id="Verify" onclick ="checkUser()">Verify</button></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <div dojoType="dijit.Dialog" id="SignUp" title="Sign Up" data-dojo-props='closable:false'>
            <form action="adminPanel.html" method="POST" validate="true" id="loginForm">
                <table >
                    <input type="hidden" value="login" name="action" id="action">
                    <tr>
                        <td><label>Name</label></td>
                        <td><input type="text" trim="true" dojoType="dijit.form.TextBox" id="Name" name="Name" required="true" focus="true"/></td>
                    </tr>
                    <tr>
                        <td><label>CNIC Number</label></td>
                        <td><input type="text" trim="true" dojoType="dijit.form.TextBox" id="username" name="username" required="true" focus="true"/></td>
                    </tr>
                    <tr>
                        <td><label>Password</label></td>
                        <td><input type="newPassword" trim="true" dojoType="dijit.form.TextBox" name="newPassword" id="newPassword" required="true"/></td>
                    </tr>
                    <tr>
                        <td><label>Confirm Password</label></td>
                        <td><input type="password" trim="true" dojoType="dijit.form.TextBox" name="ConfirmPassword" id="ConfirmPassword" required="true"/></td>
                    </tr>

                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td colspan="2" align="right">
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td></td>
                                    <td align="right" valign="top"><button dojoType="dijit.form.Button" type="submit" id="SignUpButton" onclick ="verify()">SignUp</button></td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                </table>
            </form>

        </div>

        <div dojoType="dijit.Dialog" id="Login" title="Login" data-dojo-props='closable:false'>
            <form action="adminPanel.html" method="POST" validate="true" id="loginForm">
                <table width="258">
                    <input type="hidden" value="login" name="action" id="action">

                    <tr>
                        <td><label>CNIC Number</label></td>
                        <td><input type="text" trim="true" dojoType="dijit.form.TextBox" id="CNIC" name="CNIC" required="true" focus="true"/></td>
                    </tr>
                    <tr>
                        <td><label>Password</label></td>
                        <td><input type="password" trim="true" dojoType="dijit.form.TextBox" name="password" id="password" required="true"/></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><div id="LoginInformation" style="color: red"></div></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td colspan="2" align="right">
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td></td>
                                    <td align="right" valign="top"><input  type="submit" id="LoginButton" value="LOGIN" /></td>
                                </tr>
                                <tr>
                                    <td align="left"><a href="#" onClick="showSignUpDialogue();">Sign UP</a>&nbsp;&nbsp;</td>
                                    <td align="right"><a href="#" onClick="showForgotPasswordDialog();">Forgot Password</a></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </form>
        </div>


    </body>
</html>