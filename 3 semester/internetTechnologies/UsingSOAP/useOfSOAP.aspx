<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="useOfSOAP.aspx.cs" Inherits="WebApplication1.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        <asp:Label ID="Label1" runat="server" Text="Tu pojawiają się informacje o błędach"></asp:Label>
            <br />
        </div>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Suma" />
        <br />
        <br />
        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        &nbsp;<asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:TextBox ID="TextBox3" runat="server" Width="329px"></asp:TextBox>
        <br />
        <br />
        <br />
        <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="Load studenci" />
        <br />
        <asp:GridView ID="GridView1" runat="server" AllowCustomPaging="True" AllowPaging="True" AllowSorting="True">
        </asp:GridView>
        <br />
        <br />
        <asp:Button ID="Button3" runat="server" OnClick="Button3_Click" style="height: 26px" Text="Baza studentów sql" />
        <br />
        <br />
        <br />
        <br />
        <br />
    </form>
</body>
</html>
