package com.dfh.utils;

import org.testng.Assert;

public class Assertions {

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    /**
     * Assert that the condition is false
     *
     * @param condition The condition to evaluate
     * @param message   The message to display if the assertion fails
     */
    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    /**
     * Assert that two objects are equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two objects are equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     */
    public static void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }


    /**
     * Assert that two objects are not equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that two objects refer to the same object
     *
     * @param actual   The actual object
     * @param expected The expected object
     * @param message  The message to display if the assertion fails
     */
    public static void assertSame(Object actual, Object expected, String message) {
        Assert.assertSame(actual, expected, message);
    }

    /**
     * Assert that two objects do not refer to the same object
     *
     * @param actual   The actual object
     * @param expected The expected object
     * @param message  The message to display if the assertion fails
     */
    public static void assertNotSame(Object actual, Object expected, String message) {
        Assert.assertNotSame(actual, expected, message);
    }

    /**
     * Assert that an object is null
     *
     * @param object  The object to evaluate
     * @param message The message to display if the assertion fails
     */
    public static void assertNull(Object object, String message) {
        Assert.assertNull(object, message);
    }

    /**
     * Assert that an object is not null
     *
     * @param object  The object to evaluate
     * @param message The message to display if the assertion fails
     */
    public static void assertNotNull(Object object, String message) {
        Assert.assertNotNull(object, message);
    }

    /**
     * Assert that two integer arrays are equal
     *
     * @param actual   The actual array
     * @param expected The expected array
     * @param message  The message to display if the assertion fails
     */
    public static void assertArrayEquals(int[] actual, int[] expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two integer arrays are not equal
     *
     * @param actual   The actual array
     * @param expected The expected array
     * @param message  The message to display if the assertion fails
     */
    public static void assertArrayNotEquals(int[] actual, int[] expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that two object arrays are equal
     *
     * @param actual   The actual array
     * @param expected The expected array
     * @param message  The message to display if the assertion fails
     */
    public static void assertArrayEquals(Object[] actual, Object[] expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two object arrays are not equal
     *
     * @param actual   The actual array
     * @param expected The expected array
     * @param message  The message to display if the assertion fails
     */
    public static void assertArrayNotEquals(Object[] actual, Object[] expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that two strings are equal, ignoring case
     *
     * @param actual   The actual string
     * @param expected The expected string
     * @param message  The message to display if the assertion fails
     */

    public static void assertEqualsIgnoreCase(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that a string contains another string
     *
     * @param actual   The actual string to check
     * @param expected The string expected to be contained
     * @param message  The message to display if the assertion fails
     */
    public static void assertContains(String actual, String expected, String message) {
        Assert.assertTrue(actual.contains(expected), message);
    }

    /**
     * Assert that a string starts with a given prefix
     *
     * @param actual  The actual string
     * @param prefix  The prefix to check
     * @param message The message to display if the assertion fails
     */
    public static void assertStartsWith(String actual, String prefix, String message) {
        Assert.assertTrue(actual.startsWith(prefix), message);
    }

    /**
     * Assert that a string ends with a given suffix
     *
     * @param actual  The actual string
     * @param suffix  The suffix to check
     * @param message The message to display if the assertion fails
     */
    public static void assertEndsWith(String actual, String suffix, String message) {
        Assert.assertTrue(actual.endsWith(suffix), message);
    }

    /**
     * Assert that two collections are equal
     *
     * @param actual   The actual collection
     * @param expected The expected collection
     * @param message  The message to display if the assertion fails
     */
    public static void assertEquals(java.util.Collection<?> actual, java.util.Collection<?> expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two collections are not equal
     *
     * @param actual   The actual collection
     * @param expected The expected collection
     * @param message  The message to display if the assertion fails
     */
    public static void assertNotEquals(java.util.Collection<?> actual, java.util.Collection<?> expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that a collection contains a specific element
     *
     * @param collection The collection to check
     * @param element    The element to find
     * @param message    The message to display if the assertion fails
     */
    public static void assertContainsInCollection(java.util.Collection<?> collection, Object element, String message) {
        Assert.assertTrue(collection.contains(element), message);
    }

    /**
     * Assert that a collection does not contain a specific element
     *
     * @param collection The collection to check
     * @param element    The element to find
     * @param message    The message to display if the assertion fails
     */
    public static void assertNotContainsInCollection(java.util.Collection<?> collection, Object element, String message) {
        Assert.assertFalse(collection.contains(element), message);
    }

    /**
     * Assert that an exception to the expected type is thrown
     *
     * @param expectedException The class of the expected exception
     * @param runnable          The code to execute that should throw the exception
     */
    public static void assertThrows(Class<? extends Throwable> expectedException, Runnable runnable) {
        Assert.assertThrows(expectedException, (Assert.ThrowingRunnable) runnable);
    }

    /**
     * Assert that one integer is greater than another
     *
     * @param actual   The actual integer value
     * @param expected The expected integer value
     * @param message  The message to display if the assertion fails
     */
    public static void assertGreaterThan(int actual, int expected, String message) {
        Assert.assertTrue(actual > expected, message);
    }

    /**
     * Assert that one integer is less than another
     *
     * @param actual   The actual integer value
     * @param expected The expected integer value
     * @param message  The message to display if the assertion fails
     */
    public static void assertLessThan(int actual, int expected, String message) {
        Assert.assertTrue(actual < expected, message);
    }

    /**
     * Assert that one integer is greater than or equal to another
     *
     * @param actual   The actual integer value
     * @param expected The expected integer value
     * @param message  The message to display if the assertion fails
     */
    public static void assertGreaterThanOrEqual(int actual, int expected, String message) {
        Assert.assertTrue(actual >= expected, message);
    }

    /**
     * Assert that one integer is less than or equal to another
     *
     * @param actual   The actual integer value
     * @param expected The expected integer value
     * @param message  The message to display if the assertion fails
     */
    public static void assertLessThanOrEqual(int actual, int expected, String message) {
        Assert.assertTrue(actual <= expected, message);
    }

    /**
     * Assert that a block of code executes within a specified timeout
     *
     * @param timeoutInMillis The maximum time to wait in milliseconds
     * @param runnable        The code to execute
     */
    public static void assertTimeout(long timeoutInMillis, Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long duration = System.currentTimeMillis() - startTime;
        Assert.assertTrue(duration < timeoutInMillis, "Execution time exceeded timeout of " + timeoutInMillis + " ms");
    }

    /**
     * Assert that two doubles are equal within a given tolerance
     *
     * @param actual    The actual double value
     * @param expected  The expected double value
     * @param tolerance The allowable difference
     * @param message   The message to display if the assertion fails
     */
    public static void assertEqualsWithTolerance(double actual, double expected, double tolerance, String message) {
        Assert.assertTrue(Math.abs(actual - expected) <= tolerance, message);
    }

    /**
     * Assert that a string is not empty
     *
     * @param actual  The string to check
     * @param message The message to display if the assertion fails
     */
    public static void assertNotEmpty(String actual, String message) {
        Assert.assertFalse(actual.isEmpty(), message);
    }

    /**
     * Assert that a string is empty
     *
     * @param actual  The string to check
     * @param message The message to display if the assertion fails
     */
    public static void assertEmpty(String actual, String message) {
        Assert.assertTrue(actual.isEmpty(), message);
    }

    /**
     * Assert that a string is empty
     *
     * @param string  The string to check
     * @param message The message to display if the assertion fails
     */

    public static void assertIsEmpty(String string, String message) {
        Assert.assertTrue(string.isEmpty(), message);
    }

    /**
     * Assert size of collections
     *
     * @param collection The collection to check
     * @param size       The expected size of the collection
     * @param message    The message to display if the assertion fails
     */
    public static void assertSize(java.util.Collection<?> collection, int size, String message) {
        Assert.assertEquals(collection.size(), size, message);
    }

    /**
     * Assert that a collection is empty
     *
     * @param collection The collection to check
     * @param message    The message to display if the assertion fails
     */
    public static void assertIsEmptyCollection(java.util.Collection<?> collection, String message) {
        Assert.assertTrue(collection.isEmpty(), message);
    }

    /**
     * Assert that a collection is not empty
     *
     * @param collection The collection to check
     * @param message    The message to display if the assertion fails
     */
    public static void assertIsNotEmptyCollection(java.util.Collection<?> collection, String message) {
        Assert.assertFalse(collection.isEmpty(), message);
    }

    /**
     * Assert that two double values are equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertEqualDouble(double actual, double expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two double values are not equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertNotEqualDouble(double actual, double expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that two float values are equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertEqualFloat(float actual, float expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two float values are not equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertNotEqualFloat(float actual, float expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that two long values are equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertEqualLong(long actual, long expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two long values are not equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertNotEqualLong(long actual, long expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that two short values are equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertEqualShort(short actual, short expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two short values are not equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertNotEqualShort(short actual, short expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that two byte values are equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertEqualByte(byte actual, byte expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Assert that two byte values are not equal
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @param message  The message to display if the assertion fails
     */
    public static void assertNotEqualByte(byte actual, byte expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    /**
     * Assert that all elements in a collection are not null
     *
     * @param collection The collection to check
     * @param message    The message to display if any element is null
     */
    public static void assertAllElementsNotNull(java.util.Collection<?> collection, String message) {
        for (Object item : collection) {
            assertNotNull(item, message);
        }
    }

    /**
     * Assert a specific condition is true
     *
     * @param condition The condition to check
     * @param message   The message to display if the assertion fails
     */
    public static void assertCondition(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    /**
     * Assert that a string matches a regex pattern
     *
     * @param actual  The string to check
     * @param regex   The regex pattern
     * @param message The message to display if the assertion fails
     */
    public static void assertMatches(String actual, String regex, String message) {
        Assert.assertTrue(actual.matches(regex), message);
    }

    /**
     * Assert the size of a list
     *
     * @param list         The list to check
     * @param expectedSize The expected size of the list
     * @param message      The message to display if the assertion fails
     */
    public static void assertListSize(java.util.List<?> list, int expectedSize, String message) {
        Assert.assertEquals(list.size(), expectedSize, message);
    }

    /**
     * Assert that an object is an instance of a specific class
     *
     * @param actual        The object to check
     * @param expectedClass The expected class type
     * @param message       The message to display if the assertion fails
     */
    public static void assertInstanceOf(Object actual, Class<?> expectedClass, String message) {
        Assert.assertTrue(expectedClass.isInstance(actual), message);
    }
}
