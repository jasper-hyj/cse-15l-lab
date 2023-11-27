CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar:grading-area/'
JAVA="java -cp $CPATH org.junit.runner.JUnitCore TestListExamples"

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

if ! [[ -f "student-submission/ListExamples.java" ]]
then
    echo "File not Found!"
    exit 1
fi

cp "student-submission/ListExamples.java" "grading-area"
cp TestListExamples.java "grading-area"

javac -cp $CPATH grading-area/*.java

RESULT=$($JAVA)

# echo "$RESULT"
TEST=$(echo "$RESULT" | grep -Po 'Tests\srun:\s*\K\d+')
FAILURE=$(echo "$RESULT" | grep -Po 'Failures:\s*\K\d+')

echo "Grade: $(expr $TEST - $FAILURE)"