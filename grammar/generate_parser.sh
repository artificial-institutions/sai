### to generate the parser, type ./generate_parser.sh <grammar file> <antlr 4 version>
### for example, "./generate_parser.sh sai_constitutive.g 12.0" produces files  for the grammar sai_constitutive.g with antlr4.12.0
### antlr versions are available at https://github.com/antlr/website-antlr4/tree/gh-pages/download


echo "generating parser from grammar " $1 " antlr version 4."$2 
mkdir temp
mkdir output
cd temp
wget https://github.com/antlr/website-antlr4/raw/gh-pages/download/antlr-4.$2-complete.jar temp/
chmod +x antlr-4.$2-complete.jar
cd .. 
java -jar temp/antlr-4.$2-complete.jar -listener -o output $1
rm -r temp
echo "files generated in output/ directory"
