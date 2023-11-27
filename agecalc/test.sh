set -e
javac AgeCalc.java

JAVA="java AgeCalc.java"

for test_file in "test-files"/*.txt;
do
    expected_output_file="test-files/$(basename -s .txt "$test_file").txt.expect"
    OUTPUT="$($JAVA < "$test_file")"
    
    if [ "$OUTPUT" == "$(cat "$expected_output_file")" ]; then
        echo "Test Passed!"
    else
        echo "Test Failed!"
    fi
    
done