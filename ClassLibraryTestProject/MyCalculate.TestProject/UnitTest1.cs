using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ClassLibraryTestProject.TestProject
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void squareCircleTest()
        {
            double x = 10.0;
            double rightResult = 314.1592653589793;
            AllCalculate test = new AllCalculate();

            double result = test.calculateSquare(x);

            Assert.AreEqual(rightResult, result);  
        }

        [TestMethod]
        public void squareTriangleTest()
        {
            double a = 5.0;
            double b = 7.0;
            double c = 10.0;
            double rightResult = 16.24807680927192;
            AllCalculate test = new AllCalculate();

            double result = test.calculateSquare(a, b, c);

            Assert.AreEqual(rightResult, result);
        }

        [TestMethod]
        public void squareTriangleIsRightTrueTest()
        {
            double a = 6.0;
            double b = 8.0;
            double c = 10.0;
            bool rightResult = true;
            AllCalculate test = new AllCalculate();

            bool result = test.isRight(a, b, c);

            Assert.AreEqual(rightResult, result);
        }

        [TestMethod]
        public void squareTriangleIsRightFalseTest()
        {
            double a = 6.0;
            double b = 10.0;
            double c = 10.0;
            bool rightResult = false;
            AllCalculate test = new AllCalculate();

            bool result = test.isRight(a, b, c);

            Assert.AreEqual(rightResult, result);
        }
    }
}