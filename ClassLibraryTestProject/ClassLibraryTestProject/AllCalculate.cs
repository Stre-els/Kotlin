namespace ClassLibraryTestProject
{
    public class AllCalculate : CalculateTriangle, CalculateCircle
    {
        protected double square = 0;
        public double calculateSquare(double radius)
        {
            square = Math.PI * Math.Pow(radius, 2);
            return square;
        }

        public double calculateSquare(double a, double b, double c)
        {
            double p = (a + b + c) / 2;
            square = Math.Sqrt(p * (p - a) * (p - b) * (p - c));
            return square;
        }

        public bool isRight(double a, double b, double c)
        {
            var list = new List<double>() { a, b, c };
            list.Sort();
            if (Math.Pow(list[2], 2) == (Math.Pow(list[0], 2) + Math.Pow(list[1], 2)))
            {
                return true;
            }
            else
                return false;
        }
    }

    interface CalculateTriangle
    {
        public double calculateSquare(double radius);
        public bool isRight(double a, double b, double c);
    }

    interface CalculateCircle
    {
        public double calculateSquare(double a, double b, double c);
    }
    
}