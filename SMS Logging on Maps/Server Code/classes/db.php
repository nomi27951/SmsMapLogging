<?php
    require './classes/db.class.php';
    class SanDB{
        private $db;
        function __construct()
        {
            $this->db = new DB_MySql();
            $this->db->server = "localhost";
            $this->db->database = "sanhack";
            $this->db->user = "xyz";
            $this->db->password = "123";
            $this->db->connect();
        }

        function createTable($shopName)
        {
            $this->db->query('CREATE TABLE IF NOT EXISTS '.$shopName.' (cnic int(15),longitude varchar(15),latitude varchar(15),complaint varchar(15),complaint int(15))' );
        }

        function closeDB()
        {
            $this->db->close();
        }

        function sToDB($tname,$rsrc_id,$rsrc_type,$meta_id)
        {
            $this->db->query("INSERT INTO {$tname} VALUES ({$cnic},'{$long}','{$lat}',{$complaint},{$complaintid})");
        }
    }

    
?>