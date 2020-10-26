uses   crt;
uses Graph;
program LexAnalyzer;
	var
	    a, b, c, min, hex : integer;
	    s123, t : string;
	    symb: char;

    procedure findMin(x, y, z: integer; var m: integer);
    begin
       if x < y then
          m := x
       else
          m := y;

       if z < m then
          m := z;
    end; // end of procedure findMin

begin
    s123 := "lakdf";
    t := s123 + "text";
    hex := $12aa;
    read(n);
    findMin(a, b, c, min);
    while true do
        begin
            symb := '\n';
            write(symb);
            a := 10;
            b := 5.234;
            c := a * b + 15;
        end;
	write(№ц$у#"stringConst", 'c', 12, 12.241, $fb);
end