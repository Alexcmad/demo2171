import requests
import random
from faker import Faker
from datetime import datetime, timedelta
import json

fake = Faker()

BASE_URL = "http://localhost:25565/api"
headers = {"Content-Type": "application/json"}

def create_admin():
    admin_data = {
        "name": fake.user_name(),
        "password": fake.password(length=12)
    }
    response = requests.post(f"{BASE_URL}/admin/", json=admin_data, headers=headers)
    if response.status_code == 200:
        print(f"Created admin: {admin_data['name']}")
        return response.json()
    return None

def generate_product_name():
    categories = ['Laptop', 'Phone', 'Tablet', 'Watch', 'Camera', 'Headphones', 'Speaker', 'Monitor', 'Keyboard', 'Mouse']
    brands = ['Tech', 'Pro', 'Elite', 'Smart', 'Ultra', 'Max', 'Plus', 'Premium']
    return f"{random.choice(brands)} {random.choice(categories)} {fake.unique.random_int(min=100, max=999)}"

def create_product():
    product_data = {
        "name": generate_product_name(),
        "price": round(random.uniform(10.0, 1000.0), 2),
        "quantity": random.randint(1, 1000)
    }
    response = requests.post(f"{BASE_URL}/product/", json=product_data, headers=headers)
    if response.status_code == 200:
        print(f"Created product: {product_data['name']}")
        return response.json()
    return None

def create_inventory(product_ids):
    inventory_data = {
        "products": product_ids
    }
    response = requests.post(f"{BASE_URL}/inventory/", json=inventory_data, headers=headers)
    if response.status_code == 200:
        print(f"Created inventory with {len(product_ids)} products")
        return response.json()
    return None

def create_sale(admin_id, product_name):
    quantity = random.randint(1, 10)
    price_per_unit = round(random.uniform(10.0, 100.0), 2)
    sale_data = {
        "productName": product_name,
        "date": (datetime.now() - timedelta(days=random.randint(0, 30))).isoformat(),
        "total": round(quantity * price_per_unit, 2),
        "quantity": quantity,
        "customerName": fake.name(),
        "admin": {"id": admin_id}
    }
    response = requests.post(f"{BASE_URL}/sale/", json=sale_data, headers=headers)
    if response.status_code == 200:
        print(f"Created sale: {quantity} x {product_name}")
        return response.json()
    return None

def create_purchase(admin_id, product_name):
    quantity = random.randint(10, 100)
    price_per_unit = round(random.uniform(5.0, 50.0), 2)
    purchase_data = {
        "productName": product_name,
        "date": (datetime.now() - timedelta(days=random.randint(0, 30))).isoformat(),
        "total": round(quantity * price_per_unit, 2),
        "quantity": quantity,
        "admin": {"id": admin_id}
    }
    response = requests.post(f"{BASE_URL}/purchase/", json=purchase_data, headers=headers)
    if response.status_code == 200:
        print(f"Created purchase: {quantity} x {product_name}")
        return response.json()
    return None

def generate_test_data():
    print("\n1. Creating admins...")
    # Create admins
    admins = [create_admin() for _ in range(3)]
    admin_ids = [admin['id'] for admin in admins if admin]

    print("\n2. Creating products...")
    # Create products
    products = [create_product() for _ in range(10)]
    product_ids = [product['id'] for product in products if product]
    product_names = [product['name'] for product in products if product]

    """ print("\n3. Creating inventory...")
    # Create inventory
    inventory = create_inventory(product_ids)

    print("\n4. Creating sales...")
    # Create sales and purchases
    for _ in range(20):  # Create 20 sales
        admin_id = random.choice(admin_ids)
        product_name = random.choice(product_names)
        create_sale(admin_id, product_name)

    print("\n5. Creating purchases...")
    for _ in range(10):  # Create 10 purchases
        admin_id = random.choice(admin_ids)
        product_name = random.choice(product_names)
        create_purchase(admin_id, product_name)"""

if __name__ == "__main__":
    print("Generating test data for Inventory Management System...")
    generate_test_data()
    print("\nTest data generation complete!") 